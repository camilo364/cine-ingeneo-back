package com.ingeneo.services.model.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateRoom {
    private String name;
    private int arrows;
    private int format;
    private int branch;
    private ChairArrangement[] chairs;
}
