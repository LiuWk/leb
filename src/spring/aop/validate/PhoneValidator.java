package spring.aop.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class PhoneValidator implements ConstraintValidator<Phone,String>{

	@Override
	public void initialize(Phone phone) {
		System.out.println("PhoneValidator initialize.");
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(StringUtils.isEmpty(value))
            return true;
        if(value.matches("((\\+86)|(86))?1[3|4|5|8]\\d{9}")){
            return true;
        }
        return false;
	}

}
