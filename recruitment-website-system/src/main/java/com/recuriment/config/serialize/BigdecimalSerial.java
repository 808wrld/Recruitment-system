package com.recuriment.config.serialize;

import com.alibaba.fastjson.serializer.*;

import java.text.DecimalFormat;

/**
 * @Author lqp
 * @Date 2020/11/10 21:11
 **/
public class BigdecimalSerial extends BigDecimalCodec implements ContextObjectSerializer {

    public final static BigdecimalSerial instance = new BigdecimalSerial();

    /**
     * 当BigDecimal类型的属性上有@JsonFiled注解，且该注解中的format有值时，使用该方法进行序列化，否则使用fastjson的
     * BigDecimalCodec中的write方法进行序列化
     */
    @Override
    public void write(JSONSerializer serializer, Object object, BeanContext context){
        SerializeWriter out = serializer.out;
        if(object == null) {
            out.writeString("");
            return;
        }
        String format = context.getFormat();
        DecimalFormat decimalFormat = new DecimalFormat(format);
        out.writeString(decimalFormat.format(object));
    }

}