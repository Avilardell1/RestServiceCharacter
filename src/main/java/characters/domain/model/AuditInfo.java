package characters.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class AuditInfo {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;

}
