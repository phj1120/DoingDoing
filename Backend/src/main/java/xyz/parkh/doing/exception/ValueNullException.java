package xyz.parkh.doing.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValueNullException extends RuntimeException {
    String message;
}
