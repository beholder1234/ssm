package lj.elevator.erp.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNull() {
			addCriterion("CREATETIME is null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNotNull() {
			addCriterion("CREATETIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeEqualTo(Date value) {
			addCriterionForJDBCDate("CREATETIME =", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("CREATETIME <>", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThan(Date value) {
			addCriterionForJDBCDate("CREATETIME >", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CREATETIME >=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThan(Date value) {
			addCriterionForJDBCDate("CREATETIME <", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CREATETIME <=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIn(List<Date> values) {
			addCriterionForJDBCDate("CREATETIME in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("CREATETIME not in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CREATETIME between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CREATETIME not between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andChecktimeIsNull() {
			addCriterion("CHECKTIME is null");
			return (Criteria) this;
		}

		public Criteria andChecktimeIsNotNull() {
			addCriterion("CHECKTIME is not null");
			return (Criteria) this;
		}

		public Criteria andChecktimeEqualTo(Date value) {
			addCriterionForJDBCDate("CHECKTIME =", value, "checktime");
			return (Criteria) this;
		}

		public Criteria andChecktimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("CHECKTIME <>", value, "checktime");
			return (Criteria) this;
		}

		public Criteria andChecktimeGreaterThan(Date value) {
			addCriterionForJDBCDate("CHECKTIME >", value, "checktime");
			return (Criteria) this;
		}

		public Criteria andChecktimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CHECKTIME >=", value, "checktime");
			return (Criteria) this;
		}

		public Criteria andChecktimeLessThan(Date value) {
			addCriterionForJDBCDate("CHECKTIME <", value, "checktime");
			return (Criteria) this;
		}

		public Criteria andChecktimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CHECKTIME <=", value, "checktime");
			return (Criteria) this;
		}

		public Criteria andChecktimeIn(List<Date> values) {
			addCriterionForJDBCDate("CHECKTIME in", values, "checktime");
			return (Criteria) this;
		}

		public Criteria andChecktimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("CHECKTIME not in", values, "checktime");
			return (Criteria) this;
		}

		public Criteria andChecktimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CHECKTIME between", value1, value2, "checktime");
			return (Criteria) this;
		}

		public Criteria andChecktimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CHECKTIME not between", value1, value2, "checktime");
			return (Criteria) this;
		}

		public Criteria andStarttimeIsNull() {
			addCriterion("STARTTIME is null");
			return (Criteria) this;
		}

		public Criteria andStarttimeIsNotNull() {
			addCriterion("STARTTIME is not null");
			return (Criteria) this;
		}

		public Criteria andStarttimeEqualTo(Date value) {
			addCriterionForJDBCDate("STARTTIME =", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("STARTTIME <>", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeGreaterThan(Date value) {
			addCriterionForJDBCDate("STARTTIME >", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("STARTTIME >=", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeLessThan(Date value) {
			addCriterionForJDBCDate("STARTTIME <", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("STARTTIME <=", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeIn(List<Date> values) {
			addCriterionForJDBCDate("STARTTIME in", values, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("STARTTIME not in", values, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("STARTTIME between", value1, value2, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("STARTTIME not between", value1, value2, "starttime");
			return (Criteria) this;
		}

		public Criteria andEndtimeIsNull() {
			addCriterion("ENDTIME is null");
			return (Criteria) this;
		}

		public Criteria andEndtimeIsNotNull() {
			addCriterion("ENDTIME is not null");
			return (Criteria) this;
		}

		public Criteria andEndtimeEqualTo(Date value) {
			addCriterionForJDBCDate("ENDTIME =", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("ENDTIME <>", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeGreaterThan(Date value) {
			addCriterionForJDBCDate("ENDTIME >", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ENDTIME >=", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeLessThan(Date value) {
			addCriterionForJDBCDate("ENDTIME <", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ENDTIME <=", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeIn(List<Date> values) {
			addCriterionForJDBCDate("ENDTIME in", values, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("ENDTIME not in", values, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ENDTIME between", value1, value2, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ENDTIME not between", value1, value2, "endtime");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("`TYPE` =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("TYPE <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("TYPE >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("TYPE >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("TYPE <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("TYPE <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("TYPE like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("TYPE not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("TYPE in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("TYPE not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("TYPE between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("TYPE not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andCreaterIsNull() {
			addCriterion("CREATER is null");
			return (Criteria) this;
		}

		public Criteria andCreaterIsNotNull() {
			addCriterion("CREATER is not null");
			return (Criteria) this;
		}

		public Criteria andCreaterEqualTo(String value) {
			addCriterion("CREATER =", value, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterNotEqualTo(String value) {
			addCriterion("CREATER <>", value, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterGreaterThan(String value) {
			addCriterion("CREATER >", value, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterGreaterThanOrEqualTo(String value) {
			addCriterion("CREATER >=", value, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterLessThan(String value) {
			addCriterion("CREATER <", value, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterLessThanOrEqualTo(String value) {
			addCriterion("CREATER <=", value, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterLike(String value) {
			addCriterion("CREATER like", value, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterNotLike(String value) {
			addCriterion("CREATER not like", value, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterIn(List<String> values) {
			addCriterion("CREATER in", values, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterNotIn(List<String> values) {
			addCriterion("CREATER not in", values, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterBetween(String value1, String value2) {
			addCriterion("CREATER between", value1, value2, "creater");
			return (Criteria) this;
		}

		public Criteria andCreaterNotBetween(String value1, String value2) {
			addCriterion("CREATER not between", value1, value2, "creater");
			return (Criteria) this;
		}

		public Criteria andCheckerIsNull() {
			addCriterion("CHECKER is null");
			return (Criteria) this;
		}

		public Criteria andCheckerIsNotNull() {
			addCriterion("CHECKER is not null");
			return (Criteria) this;
		}

		public Criteria andCheckerEqualTo(String value) {
			addCriterion("CHECKER =", value, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerNotEqualTo(String value) {
			addCriterion("CHECKER <>", value, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerGreaterThan(String value) {
			addCriterion("CHECKER >", value, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerGreaterThanOrEqualTo(String value) {
			addCriterion("CHECKER >=", value, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerLessThan(String value) {
			addCriterion("CHECKER <", value, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerLessThanOrEqualTo(String value) {
			addCriterion("CHECKER <=", value, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerLike(String value) {
			addCriterion("CHECKER like", value, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerNotLike(String value) {
			addCriterion("CHECKER not like", value, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerIn(List<String> values) {
			addCriterion("CHECKER in", values, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerNotIn(List<String> values) {
			addCriterion("CHECKER not in", values, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerBetween(String value1, String value2) {
			addCriterion("CHECKER between", value1, value2, "checker");
			return (Criteria) this;
		}

		public Criteria andCheckerNotBetween(String value1, String value2) {
			addCriterion("CHECKER not between", value1, value2, "checker");
			return (Criteria) this;
		}

		public Criteria andStarterIsNull() {
			addCriterion("STARTER is null");
			return (Criteria) this;
		}

		public Criteria andStarterIsNotNull() {
			addCriterion("STARTER is not null");
			return (Criteria) this;
		}

		public Criteria andStarterEqualTo(String value) {
			addCriterion("STARTER =", value, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterNotEqualTo(String value) {
			addCriterion("STARTER <>", value, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterGreaterThan(String value) {
			addCriterion("STARTER >", value, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterGreaterThanOrEqualTo(String value) {
			addCriterion("STARTER >=", value, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterLessThan(String value) {
			addCriterion("STARTER <", value, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterLessThanOrEqualTo(String value) {
			addCriterion("STARTER <=", value, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterLike(String value) {
			addCriterion("STARTER like", value, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterNotLike(String value) {
			addCriterion("STARTER not like", value, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterIn(List<String> values) {
			addCriterion("STARTER in", values, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterNotIn(List<String> values) {
			addCriterion("STARTER not in", values, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterBetween(String value1, String value2) {
			addCriterion("STARTER between", value1, value2, "starter");
			return (Criteria) this;
		}

		public Criteria andStarterNotBetween(String value1, String value2) {
			addCriterion("STARTER not between", value1, value2, "starter");
			return (Criteria) this;
		}

		public Criteria andTotalpriceIsNull() {
			addCriterion("TOTALPRICE is null");
			return (Criteria) this;
		}

		public Criteria andTotalpriceIsNotNull() {
			addCriterion("TOTALPRICE is not null");
			return (Criteria) this;
		}

		public Criteria andTotalpriceEqualTo(BigDecimal value) {
			addCriterion("TOTALPRICE =", value, "totalprice");
			return (Criteria) this;
		}

		public Criteria andTotalpriceNotEqualTo(BigDecimal value) {
			addCriterion("TOTALPRICE <>", value, "totalprice");
			return (Criteria) this;
		}

		public Criteria andTotalpriceGreaterThan(BigDecimal value) {
			addCriterion("TOTALPRICE >", value, "totalprice");
			return (Criteria) this;
		}

		public Criteria andTotalpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTALPRICE >=", value, "totalprice");
			return (Criteria) this;
		}

		public Criteria andTotalpriceLessThan(BigDecimal value) {
			addCriterion("TOTALPRICE <", value, "totalprice");
			return (Criteria) this;
		}

		public Criteria andTotalpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTALPRICE <=", value, "totalprice");
			return (Criteria) this;
		}

		public Criteria andTotalpriceIn(List<BigDecimal> values) {
			addCriterion("TOTALPRICE in", values, "totalprice");
			return (Criteria) this;
		}

		public Criteria andTotalpriceNotIn(List<BigDecimal> values) {
			addCriterion("TOTALPRICE not in", values, "totalprice");
			return (Criteria) this;
		}

		public Criteria andTotalpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTALPRICE between", value1, value2, "totalprice");
			return (Criteria) this;
		}

		public Criteria andTotalpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTALPRICE not between", value1, value2, "totalprice");
			return (Criteria) this;
		}

		public Criteria andStateIsNull() {
			addCriterion("STATE is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("STATE is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(String value) {
			addCriterion("STATE =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(String value) {
			addCriterion("STATE <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(String value) {
			addCriterion("STATE >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(String value) {
			addCriterion("STATE >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(String value) {
			addCriterion("STATE <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(String value) {
			addCriterion("STATE <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLike(String value) {
			addCriterion("STATE like", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotLike(String value) {
			addCriterion("STATE not like", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<String> values) {
			addCriterion("STATE in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<String> values) {
			addCriterion("STATE not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(String value1, String value2) {
			addCriterion("STATE between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(String value1, String value2) {
			addCriterion("STATE not between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andSupplieridIsNull() {
			addCriterion("SUPPLIERID is null");
			return (Criteria) this;
		}

		public Criteria andSupplieridIsNotNull() {
			addCriterion("SUPPLIERID is not null");
			return (Criteria) this;
		}

		public Criteria andSupplieridEqualTo(Integer value) {
			addCriterion("SUPPLIERID =", value, "supplierid");
			return (Criteria) this;
		}

		public Criteria andSupplieridNotEqualTo(Integer value) {
			addCriterion("SUPPLIERID <>", value, "supplierid");
			return (Criteria) this;
		}

		public Criteria andSupplieridGreaterThan(Integer value) {
			addCriterion("SUPPLIERID >", value, "supplierid");
			return (Criteria) this;
		}

		public Criteria andSupplieridGreaterThanOrEqualTo(Integer value) {
			addCriterion("SUPPLIERID >=", value, "supplierid");
			return (Criteria) this;
		}

		public Criteria andSupplieridLessThan(Integer value) {
			addCriterion("SUPPLIERID <", value, "supplierid");
			return (Criteria) this;
		}

		public Criteria andSupplieridLessThanOrEqualTo(Integer value) {
			addCriterion("SUPPLIERID <=", value, "supplierid");
			return (Criteria) this;
		}

		public Criteria andSupplieridIn(List<Integer> values) {
			addCriterion("SUPPLIERID in", values, "supplierid");
			return (Criteria) this;
		}

		public Criteria andSupplieridNotIn(List<Integer> values) {
			addCriterion("SUPPLIERID not in", values, "supplierid");
			return (Criteria) this;
		}

		public Criteria andSupplieridBetween(Integer value1, Integer value2) {
			addCriterion("SUPPLIERID between", value1, value2, "supplierid");
			return (Criteria) this;
		}

		public Criteria andSupplieridNotBetween(Integer value1, Integer value2) {
			addCriterion("SUPPLIERID not between", value1, value2, "supplierid");
			return (Criteria) this;
		}

		public Criteria andCustomeridIsNull() {
			addCriterion("CUSTOMERID is null");
			return (Criteria) this;
		}

		public Criteria andCustomeridIsNotNull() {
			addCriterion("CUSTOMERID is not null");
			return (Criteria) this;
		}

		public Criteria andCustomeridEqualTo(Integer value) {
			addCriterion("CUSTOMERID =", value, "customerid");
			return (Criteria) this;
		}

		public Criteria andCustomeridNotEqualTo(Integer value) {
			addCriterion("CUSTOMERID <>", value, "customerid");
			return (Criteria) this;
		}

		public Criteria andCustomeridGreaterThan(Integer value) {
			addCriterion("CUSTOMERID >", value, "customerid");
			return (Criteria) this;
		}

		public Criteria andCustomeridGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUSTOMERID >=", value, "customerid");
			return (Criteria) this;
		}

		public Criteria andCustomeridLessThan(Integer value) {
			addCriterion("CUSTOMERID <", value, "customerid");
			return (Criteria) this;
		}

		public Criteria andCustomeridLessThanOrEqualTo(Integer value) {
			addCriterion("CUSTOMERID <=", value, "customerid");
			return (Criteria) this;
		}

		public Criteria andCustomeridIn(List<Integer> values) {
			addCriterion("CUSTOMERID in", values, "customerid");
			return (Criteria) this;
		}

		public Criteria andCustomeridNotIn(List<Integer> values) {
			addCriterion("CUSTOMERID not in", values, "customerid");
			return (Criteria) this;
		}

		public Criteria andCustomeridBetween(Integer value1, Integer value2) {
			addCriterion("CUSTOMERID between", value1, value2, "customerid");
			return (Criteria) this;
		}

		public Criteria andCustomeridNotBetween(Integer value1, Integer value2) {
			addCriterion("CUSTOMERID not between", value1, value2, "customerid");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}