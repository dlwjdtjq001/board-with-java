package dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwritter;
    private Date bdate;
}
