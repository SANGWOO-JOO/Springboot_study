package Rest.API.demo.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {

    @ApiModelProperty(value = "응답 성공 여부: T/F")
    private boolean success; //success는 API의 성공, 실패 여부를 나타냄

    @ApiModelProperty(value = "응답 코드: >= 0 정상, < 0 비정상")
    private int code;

    @ApiModelProperty(value = "응답 메시지")
    private String msg;
}