package com.gaebaljip.exceed.nutritionist.exception;

import com.gaebaljip.exceed.common.Error;
import com.gaebaljip.exceed.common.annotation.ExplainError;
import com.gaebaljip.exceed.common.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Objects;
@Getter
@AllArgsConstructor
public enum NutritionistErrorCode implements BaseErrorCode {

    INVALID_MEAL(400,"4451", "존재하지 않는 식사입니다."),
    ;
    private final Integer status;
    private final String code;
    private final String reason;

    @Override
    public Error getError() {
        return Error.builder().reason(reason).code(code).status(status.toString()).build();
    }

    @Override
    public String getExplainError() throws NoSuchFieldException {
        Field field = this.getClass().getField(this.name());
        ExplainError annotation = field.getAnnotation(ExplainError.class);
        return Objects.nonNull(annotation) ? annotation.value() : this.getReason();
    }
}
