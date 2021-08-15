package lj.elevator.erp.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentExample() {
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

        public Criteria andNumIsNull() {
            addCriterion("NUM is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(String value) {
            addCriterion("NUM =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(String value) {
            addCriterion("NUM <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(String value) {
            addCriterion("NUM >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(String value) {
            addCriterion("NUM >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(String value) {
            addCriterion("NUM <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(String value) {
            addCriterion("NUM <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLike(String value) {
            addCriterion("NUM like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotLike(String value) {
            addCriterion("NUM not like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<String> values) {
            addCriterion("NUM in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<String> values) {
            addCriterion("NUM not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(String value1, String value2) {
            addCriterion("NUM between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(String value1, String value2) {
            addCriterion("NUM not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Integer value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Integer value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Integer value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Integer value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Integer value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Integer> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Integer> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Integer value1, Integer value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("MODEL is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("MODEL =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("MODEL <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("MODEL >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("MODEL <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("MODEL <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("MODEL like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("MODEL not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("MODEL in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("MODEL not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("MODEL between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("MODEL not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLoadIsNull() {
            addCriterion("LOAD is null");
            return (Criteria) this;
        }

        public Criteria andLoadIsNotNull() {
            addCriterion("LOAD is not null");
            return (Criteria) this;
        }

        public Criteria andLoadEqualTo(String value) {
            addCriterion("LOAD =", value, "load");
            return (Criteria) this;
        }

        public Criteria andLoadNotEqualTo(String value) {
            addCriterion("LOAD <>", value, "load");
            return (Criteria) this;
        }

        public Criteria andLoadGreaterThan(String value) {
            addCriterion("LOAD >", value, "load");
            return (Criteria) this;
        }

        public Criteria andLoadGreaterThanOrEqualTo(String value) {
            addCriterion("LOAD >=", value, "load");
            return (Criteria) this;
        }

        public Criteria andLoadLessThan(String value) {
            addCriterion("LOAD <", value, "load");
            return (Criteria) this;
        }

        public Criteria andLoadLessThanOrEqualTo(String value) {
            addCriterion("LOAD <=", value, "load");
            return (Criteria) this;
        }

        public Criteria andLoadLike(String value) {
            addCriterion("LOAD like", value, "load");
            return (Criteria) this;
        }

        public Criteria andLoadNotLike(String value) {
            addCriterion("LOAD not like", value, "load");
            return (Criteria) this;
        }

        public Criteria andLoadIn(List<String> values) {
            addCriterion("LOAD in", values, "load");
            return (Criteria) this;
        }

        public Criteria andLoadNotIn(List<String> values) {
            addCriterion("LOAD not in", values, "load");
            return (Criteria) this;
        }

        public Criteria andLoadBetween(String value1, String value2) {
            addCriterion("LOAD between", value1, value2, "load");
            return (Criteria) this;
        }

        public Criteria andLoadNotBetween(String value1, String value2) {
            addCriterion("LOAD not between", value1, value2, "load");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("SPEED is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("SPEED is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(BigDecimal value) {
            addCriterion("SPEED =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(BigDecimal value) {
            addCriterion("SPEED <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(BigDecimal value) {
            addCriterion("SPEED >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SPEED >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(BigDecimal value) {
            addCriterion("SPEED <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SPEED <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<BigDecimal> values) {
            addCriterion("SPEED in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<BigDecimal> values) {
            addCriterion("SPEED not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPEED between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPEED not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andLayerandstationIsNull() {
            addCriterion("LAYERANDSTATION is null");
            return (Criteria) this;
        }

        public Criteria andLayerandstationIsNotNull() {
            addCriterion("LAYERANDSTATION is not null");
            return (Criteria) this;
        }

        public Criteria andLayerandstationEqualTo(String value) {
            addCriterion("LAYERANDSTATION =", value, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationNotEqualTo(String value) {
            addCriterion("LAYERANDSTATION <>", value, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationGreaterThan(String value) {
            addCriterion("LAYERANDSTATION >", value, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationGreaterThanOrEqualTo(String value) {
            addCriterion("LAYERANDSTATION >=", value, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationLessThan(String value) {
            addCriterion("LAYERANDSTATION <", value, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationLessThanOrEqualTo(String value) {
            addCriterion("LAYERANDSTATION <=", value, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationLike(String value) {
            addCriterion("LAYERANDSTATION like", value, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationNotLike(String value) {
            addCriterion("LAYERANDSTATION not like", value, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationIn(List<String> values) {
            addCriterion("LAYERANDSTATION in", values, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationNotIn(List<String> values) {
            addCriterion("LAYERANDSTATION not in", values, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationBetween(String value1, String value2) {
            addCriterion("LAYERANDSTATION between", value1, value2, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andLayerandstationNotBetween(String value1, String value2) {
            addCriterion("LAYERANDSTATION not between", value1, value2, "layerandstation");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
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

        public Criteria andScrapdateIsNull() {
            addCriterion("SCRAPDATE is null");
            return (Criteria) this;
        }

        public Criteria andScrapdateIsNotNull() {
            addCriterion("SCRAPDATE is not null");
            return (Criteria) this;
        }

        public Criteria andScrapdateEqualTo(Date value) {
            addCriterionForJDBCDate("SCRAPDATE =", value, "scrapdate");
            return (Criteria) this;
        }

        public Criteria andScrapdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SCRAPDATE <>", value, "scrapdate");
            return (Criteria) this;
        }

        public Criteria andScrapdateGreaterThan(Date value) {
            addCriterionForJDBCDate("SCRAPDATE >", value, "scrapdate");
            return (Criteria) this;
        }

        public Criteria andScrapdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SCRAPDATE >=", value, "scrapdate");
            return (Criteria) this;
        }

        public Criteria andScrapdateLessThan(Date value) {
            addCriterionForJDBCDate("SCRAPDATE <", value, "scrapdate");
            return (Criteria) this;
        }

        public Criteria andScrapdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SCRAPDATE <=", value, "scrapdate");
            return (Criteria) this;
        }

        public Criteria andScrapdateIn(List<Date> values) {
            addCriterionForJDBCDate("SCRAPDATE in", values, "scrapdate");
            return (Criteria) this;
        }

        public Criteria andScrapdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SCRAPDATE not in", values, "scrapdate");
            return (Criteria) this;
        }

        public Criteria andScrapdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SCRAPDATE between", value1, value2, "scrapdate");
            return (Criteria) this;
        }

        public Criteria andScrapdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SCRAPDATE not between", value1, value2, "scrapdate");
            return (Criteria) this;
        }

        public Criteria andInstalltimeIsNull() {
            addCriterion("INSTALLTIME is null");
            return (Criteria) this;
        }

        public Criteria andInstalltimeIsNotNull() {
            addCriterion("INSTALLTIME is not null");
            return (Criteria) this;
        }

        public Criteria andInstalltimeEqualTo(Date value) {
            addCriterionForJDBCDate("INSTALLTIME =", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("INSTALLTIME <>", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeGreaterThan(Date value) {
            addCriterionForJDBCDate("INSTALLTIME >", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INSTALLTIME >=", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeLessThan(Date value) {
            addCriterionForJDBCDate("INSTALLTIME <", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INSTALLTIME <=", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeIn(List<Date> values) {
            addCriterionForJDBCDate("INSTALLTIME in", values, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("INSTALLTIME not in", values, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INSTALLTIME between", value1, value2, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INSTALLTIME not between", value1, value2, "installtime");
            return (Criteria) this;
        }

        public Criteria andOpertimeIsNull() {
            addCriterion("OPERTIME is null");
            return (Criteria) this;
        }

        public Criteria andOpertimeIsNotNull() {
            addCriterion("OPERTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOpertimeEqualTo(Date value) {
            addCriterionForJDBCDate("OPERTIME =", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("OPERTIME <>", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeGreaterThan(Date value) {
            addCriterionForJDBCDate("OPERTIME >", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERTIME >=", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeLessThan(Date value) {
            addCriterionForJDBCDate("OPERTIME <", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERTIME <=", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeIn(List<Date> values) {
            addCriterionForJDBCDate("OPERTIME in", values, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("OPERTIME not in", values, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERTIME between", value1, value2, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERTIME not between", value1, value2, "opertime");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeIsNull() {
            addCriterion("SECEXAMTIME is null");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeIsNotNull() {
            addCriterion("SECEXAMTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeEqualTo(Date value) {
            addCriterionForJDBCDate("SECEXAMTIME =", value, "secexamtime");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("SECEXAMTIME <>", value, "secexamtime");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("SECEXAMTIME >", value, "secexamtime");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SECEXAMTIME >=", value, "secexamtime");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeLessThan(Date value) {
            addCriterionForJDBCDate("SECEXAMTIME <", value, "secexamtime");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SECEXAMTIME <=", value, "secexamtime");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeIn(List<Date> values) {
            addCriterionForJDBCDate("SECEXAMTIME in", values, "secexamtime");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("SECEXAMTIME not in", values, "secexamtime");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SECEXAMTIME between", value1, value2, "secexamtime");
            return (Criteria) this;
        }

        public Criteria andSecexamtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SECEXAMTIME not between", value1, value2, "secexamtime");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeIsNull() {
            addCriterion("ANNUALEXAMTIME is null");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeIsNotNull() {
            addCriterion("ANNUALEXAMTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeEqualTo(Date value) {
            addCriterionForJDBCDate("ANNUALEXAMTIME =", value, "annualexamtime");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ANNUALEXAMTIME <>", value, "annualexamtime");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ANNUALEXAMTIME >", value, "annualexamtime");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ANNUALEXAMTIME >=", value, "annualexamtime");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeLessThan(Date value) {
            addCriterionForJDBCDate("ANNUALEXAMTIME <", value, "annualexamtime");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ANNUALEXAMTIME <=", value, "annualexamtime");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeIn(List<Date> values) {
            addCriterionForJDBCDate("ANNUALEXAMTIME in", values, "annualexamtime");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ANNUALEXAMTIME not in", values, "annualexamtime");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ANNUALEXAMTIME between", value1, value2, "annualexamtime");
            return (Criteria) this;
        }

        public Criteria andAnnualexamtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ANNUALEXAMTIME not between", value1, value2, "annualexamtime");
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