package com.example.educate_backend.service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import com.example.educate_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RefreshtokenService{

  private RefreshTokenRepository refreshTokenRepository;
  @Value("${app.jwt.refresh-expiration}")
  private long refreshExpirationMsg;
  
  public Refreshtoken createRefreshToken(User user){
    refreshTokenRepository.deleteByUser(user);
    RefreshToken refreshtoken = new RefreshToken;
    refreshtoken.setUser(user);
    refreshtoken.setToken(UUID.randomUUID().toString());
    refreshtoken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMsg));
    return refreshTokenRepository.save(refreshtoken);
  
  public RefrehToken VerifyExpiration(refreshtoken token){
    if(token.getExpiryDate().isBefore(Instant.now())){
      refreshTokenRepository.delete(token);
      log.warn("Refresh token expired");
      return new AuthenticationException("Refresh token expiry.login again");
    }
    return token;
  }

    public Refreshtoken findByToken(String token){
      return refreshTokenRepository.findByToken(token).rElseThrow()->new AuthenticationException("Invalid Token");
    }


  }
}

