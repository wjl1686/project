package com.ejobim.opplat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipAttachmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipAttachmentExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoIsNull() {
            addCriterion("attachment_no is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoIsNotNull() {
            addCriterion("attachment_no is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoEqualTo(String value) {
            addCriterion("attachment_no =", value, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoNotEqualTo(String value) {
            addCriterion("attachment_no <>", value, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoGreaterThan(String value) {
            addCriterion("attachment_no >", value, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_no >=", value, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoLessThan(String value) {
            addCriterion("attachment_no <", value, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoLessThanOrEqualTo(String value) {
            addCriterion("attachment_no <=", value, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoLike(String value) {
            addCriterion("attachment_no like", value, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoNotLike(String value) {
            addCriterion("attachment_no not like", value, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoIn(List<String> values) {
            addCriterion("attachment_no in", values, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoNotIn(List<String> values) {
            addCriterion("attachment_no not in", values, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoBetween(String value1, String value2) {
            addCriterion("attachment_no between", value1, value2, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentNoNotBetween(String value1, String value2) {
            addCriterion("attachment_no not between", value1, value2, "attachmentNo");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameIsNull() {
            addCriterion("attachment_filename is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameIsNotNull() {
            addCriterion("attachment_filename is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameEqualTo(String value) {
            addCriterion("attachment_filename =", value, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameNotEqualTo(String value) {
            addCriterion("attachment_filename <>", value, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameGreaterThan(String value) {
            addCriterion("attachment_filename >", value, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_filename >=", value, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameLessThan(String value) {
            addCriterion("attachment_filename <", value, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameLessThanOrEqualTo(String value) {
            addCriterion("attachment_filename <=", value, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameLike(String value) {
            addCriterion("attachment_filename like", value, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameNotLike(String value) {
            addCriterion("attachment_filename not like", value, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameIn(List<String> values) {
            addCriterion("attachment_filename in", values, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameNotIn(List<String> values) {
            addCriterion("attachment_filename not in", values, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameBetween(String value1, String value2) {
            addCriterion("attachment_filename between", value1, value2, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilenameNotBetween(String value1, String value2) {
            addCriterion("attachment_filename not between", value1, value2, "attachmentFilename");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeIsNull() {
            addCriterion("attachment_describe is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeIsNotNull() {
            addCriterion("attachment_describe is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeEqualTo(String value) {
            addCriterion("attachment_describe =", value, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeNotEqualTo(String value) {
            addCriterion("attachment_describe <>", value, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeGreaterThan(String value) {
            addCriterion("attachment_describe >", value, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_describe >=", value, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeLessThan(String value) {
            addCriterion("attachment_describe <", value, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeLessThanOrEqualTo(String value) {
            addCriterion("attachment_describe <=", value, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeLike(String value) {
            addCriterion("attachment_describe like", value, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeNotLike(String value) {
            addCriterion("attachment_describe not like", value, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeIn(List<String> values) {
            addCriterion("attachment_describe in", values, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeNotIn(List<String> values) {
            addCriterion("attachment_describe not in", values, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeBetween(String value1, String value2) {
            addCriterion("attachment_describe between", value1, value2, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentDescribeNotBetween(String value1, String value2) {
            addCriterion("attachment_describe not between", value1, value2, "attachmentDescribe");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadIsNull() {
            addCriterion("attachment_upload is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadIsNotNull() {
            addCriterion("attachment_upload is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadEqualTo(String value) {
            addCriterion("attachment_upload =", value, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadNotEqualTo(String value) {
            addCriterion("attachment_upload <>", value, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadGreaterThan(String value) {
            addCriterion("attachment_upload >", value, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_upload >=", value, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadLessThan(String value) {
            addCriterion("attachment_upload <", value, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadLessThanOrEqualTo(String value) {
            addCriterion("attachment_upload <=", value, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadLike(String value) {
            addCriterion("attachment_upload like", value, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadNotLike(String value) {
            addCriterion("attachment_upload not like", value, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadIn(List<String> values) {
            addCriterion("attachment_upload in", values, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadNotIn(List<String> values) {
            addCriterion("attachment_upload not in", values, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadBetween(String value1, String value2) {
            addCriterion("attachment_upload between", value1, value2, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadNotBetween(String value1, String value2) {
            addCriterion("attachment_upload not between", value1, value2, "attachmentUpload");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeIsNull() {
            addCriterion("attachment_upload_time is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeIsNotNull() {
            addCriterion("attachment_upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeEqualTo(Date value) {
            addCriterion("attachment_upload_time =", value, "attachmentUploadTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeNotEqualTo(Date value) {
            addCriterion("attachment_upload_time <>", value, "attachmentUploadTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeGreaterThan(Date value) {
            addCriterion("attachment_upload_time >", value, "attachmentUploadTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attachment_upload_time >=", value, "attachmentUploadTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeLessThan(Date value) {
            addCriterion("attachment_upload_time <", value, "attachmentUploadTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("attachment_upload_time <=", value, "attachmentUploadTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeIn(List<Date> values) {
            addCriterion("attachment_upload_time in", values, "attachmentUploadTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeNotIn(List<Date> values) {
            addCriterion("attachment_upload_time not in", values, "attachmentUploadTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeBetween(Date value1, Date value2) {
            addCriterion("attachment_upload_time between", value1, value2, "attachmentUploadTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("attachment_upload_time not between", value1, value2, "attachmentUploadTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathIsNull() {
            addCriterion("attachment_filepath is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathIsNotNull() {
            addCriterion("attachment_filepath is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathEqualTo(String value) {
            addCriterion("attachment_filepath =", value, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathNotEqualTo(String value) {
            addCriterion("attachment_filepath <>", value, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathGreaterThan(String value) {
            addCriterion("attachment_filepath >", value, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_filepath >=", value, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathLessThan(String value) {
            addCriterion("attachment_filepath <", value, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathLessThanOrEqualTo(String value) {
            addCriterion("attachment_filepath <=", value, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathLike(String value) {
            addCriterion("attachment_filepath like", value, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathNotLike(String value) {
            addCriterion("attachment_filepath not like", value, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathIn(List<String> values) {
            addCriterion("attachment_filepath in", values, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathNotIn(List<String> values) {
            addCriterion("attachment_filepath not in", values, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathBetween(String value1, String value2) {
            addCriterion("attachment_filepath between", value1, value2, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andAttachmentFilepathNotBetween(String value1, String value2) {
            addCriterion("attachment_filepath not between", value1, value2, "attachmentFilepath");
            return (Criteria) this;
        }

        public Criteria andEquipNoIsNull() {
            addCriterion("equip_no is null");
            return (Criteria) this;
        }

        public Criteria andEquipNoIsNotNull() {
            addCriterion("equip_no is not null");
            return (Criteria) this;
        }

        public Criteria andEquipNoEqualTo(String value) {
            addCriterion("equip_no =", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotEqualTo(String value) {
            addCriterion("equip_no <>", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoGreaterThan(String value) {
            addCriterion("equip_no >", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoGreaterThanOrEqualTo(String value) {
            addCriterion("equip_no >=", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLessThan(String value) {
            addCriterion("equip_no <", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLessThanOrEqualTo(String value) {
            addCriterion("equip_no <=", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoLike(String value) {
            addCriterion("equip_no like", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotLike(String value) {
            addCriterion("equip_no not like", value, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoIn(List<String> values) {
            addCriterion("equip_no in", values, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotIn(List<String> values) {
            addCriterion("equip_no not in", values, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoBetween(String value1, String value2) {
            addCriterion("equip_no between", value1, value2, "equipNo");
            return (Criteria) this;
        }

        public Criteria andEquipNoNotBetween(String value1, String value2) {
            addCriterion("equip_no not between", value1, value2, "equipNo");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(Integer value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(Integer value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(Integer value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(Integer value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(Integer value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<Integer> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<Integer> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(Integer value1, Integer value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
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