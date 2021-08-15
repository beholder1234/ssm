package lj.elevator.erp.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.GoodspriceMapper;
import lj.elevator.erp.pojo.Goodsprice;
import lj.elevator.erp.pojo.GoodspriceExample;
import lj.elevator.erp.pojo.GoodspriceExample.Criteria;
import lj.elevator.erp.pojo.Orderdetail;
import lj.elevator.erp.service.GoodspriceService;

@Service
public class GoodspriceServiceImpl implements GoodspriceService {

	@Autowired
	private GoodspriceMapper mapper;

	@Override
	public List<Goodsprice> selectGoodspriceByGoodId(Integer goodsId) {

		GoodspriceExample example = new GoodspriceExample();
		Criteria criteria = example.createCriteria();
		criteria.andGoodsidEqualTo(goodsId);

		List<Goodsprice> goodsprices = mapper.selectByExample(example);
		return goodsprices;
	}

	@Override
	public void insertPrice(Orderdetail orderdetail) {

		System.out.println("insertPrice start...");
		GoodspriceExample goodspriceExample = new GoodspriceExample();

		Criteria criteria = goodspriceExample.createCriteria();

		criteria.andInpriceEqualTo(orderdetail.getPrice());
		BigDecimal bigDecimal2 = new BigDecimal(1.5);
		criteria.andOutpriceEqualTo(orderdetail.getPrice().multiply(bigDecimal2));
		criteria.andGoodsidEqualTo(orderdetail.getGoodsid());

		List<Goodsprice> goodsprices = mapper.selectByExample(goodspriceExample);

		if (goodsprices.size() != 0) {
			System.out.println("insertPrice update...");
			Goodsprice goodsprice = goodsprices.get(0);

			Integer num = goodsprice.getNum();
			num = num + orderdetail.getNum();
			goodsprice.setNum(num);

			mapper.updateByPrimaryKeySelective(goodsprice);

		} else {
			System.out.println("insertPrice insert...");
			Goodsprice goodsprice = new Goodsprice();

			goodsprice.setGoodsid(orderdetail.getGoodsid());
			goodsprice.setInprice(orderdetail.getPrice());
			goodsprice.setNum(orderdetail.getNum());

			mapper.insertSelective(goodsprice);

		}

	}

	@Override
	public void outputPrice(Orderdetail orderdetail) {

		System.out.println("outputPrice start...");
		GoodspriceExample goodspriceExample = new GoodspriceExample();

		Criteria criteria = goodspriceExample.createCriteria();

		criteria.andInpriceEqualTo(orderdetail.getPrice());
		criteria.andGoodsidEqualTo(orderdetail.getGoodsid());

		List<Goodsprice> goodsprices = mapper.selectByExample(goodspriceExample);

		if (goodsprices.size() != 0) {
			System.out.println("outputPrice update...");
			Integer orderNum = orderdetail.getNum();
			for (Goodsprice goodsprice : goodsprices) {

				if (goodsprice.getNum() > orderNum) {
					int leftNum = goodsprice.getNum() - orderNum;
					goodsprice.setNum(leftNum);
					mapper.updateByPrimaryKeySelective(goodsprice);
					break;
				} else if (goodsprice.getNum() == orderNum) {
					mapper.deleteByPrimaryKey(goodsprice.getId());
					break;
				} else if (goodsprice.getNum() < orderNum) {
					orderNum = orderNum - goodsprice.getNum();
					mapper.deleteByPrimaryKey(goodsprice.getId());
				}
			}

		} else {
			System.out.println("goodsprices 中未找到目标商品");

		}

	}

}
