package com.fee.managefeeapi.model.modelInput;

import com.fee.managefeeapi.model.Fee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInput {
    private int id;
    private int amount;
    private String date;
    private String description;
    private Fee fee;
}
