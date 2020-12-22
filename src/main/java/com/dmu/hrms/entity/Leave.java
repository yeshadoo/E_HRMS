package com.dmu.hrms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Leave {
    private Integer id;

    private Integer staffId;

    private String sname;

    private String leaveDate;

    private String leaveReason;

    private String status;

    private Staff staff;
}