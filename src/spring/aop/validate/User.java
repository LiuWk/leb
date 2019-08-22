package spring.aop.validate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年5月25日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年5月25日]创建文件 by lwk
 *     Bean Validation 中内置的 constraint  
   
    @Null   被注释的元素必须为 null  
    @NotNull    被注释的元素必须不为 null  
    @AssertTrue     被注释的元素必须为 true  
    @AssertFalse    被注释的元素必须为 false  
    @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值  
    @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值  
    @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值  
    @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值  
    @Size(max=, min=)   被注释的元素的大小必须在指定的范围内  
    @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内  
    @Past   被注释的元素必须是一个过去的日期  
    @Future     被注释的元素必须是一个将来的日期  
    @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式  
      
    Hibernate Validator 附加的 constraint  
    @NotBlank(message =)   验证字符串非null，且长度必须大于0  
    @Email  被注释的元素必须是电子邮箱地址  
    @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内  
    @NotEmpty   被注释的字符串的必须非空  
    @Range(min=,max=,message=)  被注释的元素必须在合适的范围内  
 */
@Component
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Phone(message = "手机号非法！")
    @NotNull(message = "手机号不能为空！")
    private String phone;

    private String name;
    
    @Value("${config.url}")
    private String url;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("注入属性值："+phone);
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("注入属性值："+name);
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "User [phone=" + phone + ", name=" + name + "]";
    }

}
