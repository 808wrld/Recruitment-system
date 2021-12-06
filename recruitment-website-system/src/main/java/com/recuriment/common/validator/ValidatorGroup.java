/**   
 * Copyright © 2018 intellifai Info. All rights reserved.
 * 
 * @Package: com.intellifai.eye.common.validator 
 */
package com.recuriment.common.validator;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * @ClassName: ValidatorGroup
 * @author:
 * @date:
 */
public class ValidatorGroup {

	public interface First {
	}

	public interface Second {
	}
	
	@GroupSequence({First.class, Second.class, Default.class})
	public interface ValidatorGroup1{}
}
