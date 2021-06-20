package com.ppoox.api.biz.sample;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ppoox.api.sys.base.BaseObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Sample extends BaseObject {

    @Min(value = 1, message = "번호는 필수입니다.")
    private int no;

    @Size(min = 3, max = 20, message = "이름이 올바르지 않습니다.")
    private String name;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호가 올바르지 않습니다.")
    private String phoneNumber;

    @Email(message = "이메일이 올바르지 않습니다.")
    private String email;

    public Sample() {}

    public Sample(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
