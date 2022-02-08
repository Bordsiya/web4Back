package com.example.web4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table (name = "SHOTS")
@NoArgsConstructor
@Getter
@Setter
public class DotEntity {
    @Id
    @Column (name = "ID", nullable = false)
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne (optional = false) // not null
    @JoinColumn (name = "USER_ID", nullable = false)
    private UserEntity user;

    @Column (name = "X", nullable = false)
    private Double x;

    @Column (name = "Y", nullable = false)
    private Double y;

    @Column (name = "R", nullable = false)
    private Double r;

    @Column (name = "IS_HIT", nullable = false)
    private Boolean isHit;

    @Column(name = "TIME", nullable = false)
    private String time;

    public DotEntity(Double x, Double y, Double r, UserEntity userEntity){
        this.x = x;
        this.y = y;
        this.r = r;
        this.user = userEntity;
        this.isHit = check();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        time = formatter.format(date);
    }

    public boolean check() {
        return checkCircle() || checkTriangle() || checkRectangle();
    }

    private boolean checkCircle() {
        return x <= 0 && x >= -r/2 && y <= 0 && x * x + y * y <= (r/2) * (r/2);
    }

    private boolean checkTriangle() {
        return x >= 0 && x <= r && y >= 0 && y <= -x/2 + r/2;
    }

    private boolean checkRectangle() {
        return x <= 0 && x >= -r && y >= 0 && y <= r;
    }

}
