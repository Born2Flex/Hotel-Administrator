package org.task.gfl_final.guest.dto;

import lombok.Data;

import java.util.List;

@Data
public class GuestPageDTO {
    private long currPage;
    private long numOfPages;
    private List<GuestShortDTO> orderList;
}
