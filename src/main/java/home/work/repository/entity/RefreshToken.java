package home.work.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Table(name = "REFRESH_TOKEN")
@Entity
public class RefreshToken {

    @Id
    private String key;
    private String token;
    private String refreshToken;

    public RefreshToken updateValue(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
        return this;
    }

    @Builder
    public RefreshToken(String key, String token, String refreshToken) {
        this.key = key;
        this.token = token;
        this.refreshToken = refreshToken;
    }
}
