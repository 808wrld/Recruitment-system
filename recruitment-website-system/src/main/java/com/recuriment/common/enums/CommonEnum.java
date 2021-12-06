package com.recuriment.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Locale;

/**
 * @Author
 * @Date
 **/
public class CommonEnum {

    @Getter
    public enum ExperienceEnum implements BaseEnum, IEnum<Integer>{

        NONE(1, "不限"),
        IN_ONE_YEAR(2, "一年以内"),
        ONE_TO_THREE(3, "一到三年"),
        ABOVE_THREE4(4, "三年以上"),
        ;

        private Integer value;

        private String title;

        ExperienceEnum(Integer value, String title) {
            this.value = value;
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    @Getter
    public enum EducationEnum implements BaseEnum, IEnum<Integer>{

        NONE(1, "不限"),
        SENIOR_COLLEGE(2, "大专"),
        REGULAR_COLLEGE(3, "本科"),
        MASTER(4, "硕士"),
        DOCTOR(5, "博士")
        ;
        private Integer value;

        private String title;

        EducationEnum(Integer value, String title) {
            this.value = value;
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    @Getter
    public enum JobTypeEnum implements BaseEnum, IEnum<Integer>{

        NETWORK(1, "互联网"),
        ELECTRONIC_COMMERCE(2, "电子商务"),
        MEDICAL_TREATMEMT(3, "医疗"),
        FINANCE(4, "金融"),
        BUSINESS(5, "运营"),
        ;
        private Integer value;

        private String title;

        JobTypeEnum(Integer value, String title) {
            this.value = value;
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
    }


    @Getter
    public enum CityTypeEnum implements BaseEnum, IEnum<Integer>{

        BEIJING(1, "北京"),
        TIANJING(2, "天津"),
        CHENGDU(3, "成都"),
        GUANGZHOU(4, "广州"),
        NANJING(5, "南京"),
        SHENZHEN(5, "深圳"),
        XI_AN(5, "西安"),
        WUHAN(5, "武汉"),
        SHANGHAI(5, "上海"),
        ;

        @JsonValue
        private Integer value;

        private String title;

        CityTypeEnum(Integer value, String title) {
            this.value = value;
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
    }





}
