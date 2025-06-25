package ytx.openmall.server.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import ytx.openmall.common.properties.JwtProperty;
import ytx.openmall.common.util.JWTUtils;
import ytx.openmall.common.util.OssUtils;
import ytx.openmall.pojo.DTO.SellerLoginDTO;
import ytx.openmall.pojo.DTO.SellerUpdateDTO;
import ytx.openmall.pojo.DTO.SellerUpdatePasswordDTO;
import ytx.openmall.pojo.VO.SellerLoginVO;
import ytx.openmall.pojo.entity.Seller;
import ytx.openmall.server.mapper.SellerMapper;
import ytx.openmall.server.service.SellerService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class SellerServiceImpl implements SellerService {


    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private JwtProperty jwtProperty;


    /**
     * 新增商家
     * @param seller
     */
    @Override
    public void insert(Seller seller) {
        seller.setCreateTime(LocalDate.now());
        seller.setUpdateTime(LocalDate.now());
        //密码加密存储
        String password= DigestUtils.md5DigestAsHex(seller.getPassword().getBytes(StandardCharsets.UTF_8));
        seller.setPassword(password);
        sellerMapper.insert(seller);
    }

    /**
     * 商家登录
     * @param sellerLoginDTO
     * @return
     */
    @Override
    public SellerLoginVO login(SellerLoginDTO sellerLoginDTO) {
        String password= DigestUtils.md5DigestAsHex(sellerLoginDTO.getPassword().getBytes(StandardCharsets.UTF_8));

        sellerLoginDTO.setPassword(password);
        SellerLoginVO sellerLoginVO=sellerMapper.login(sellerLoginDTO);

        Map<String, Object> claims=new HashMap<>();
        claims.put("SellerID",sellerLoginVO.getId());
        String jwt=JWTUtils.generateJWT(jwtProperty.getSellerSecretKey(), jwtProperty.getSellerTtl(), claims);
        sellerLoginVO.setJwt(jwt);
        return sellerLoginVO;
    }

    /**
     * 商家修改密码
     * @param sellerUpdatePasswordDTO
     * @return
     */
    @Override
    public int updatePassword(SellerUpdatePasswordDTO sellerUpdatePasswordDTO) {
        String oldPassword= DigestUtils.md5DigestAsHex(sellerUpdatePasswordDTO.getOldPassword().getBytes(StandardCharsets.UTF_8));
        Seller seller=sellerMapper.queryById(sellerUpdatePasswordDTO.getId());
        if (seller==null){
            return 1;  //用户不存在
        }
        if (!seller.getPassword().equals(oldPassword)){
            return 2;  //密码错误
        }
        String newPassword=DigestUtils.md5DigestAsHex(sellerUpdatePasswordDTO.getNewPassword().getBytes(StandardCharsets.UTF_8));
        seller.setPassword(newPassword);
        seller.setUpdateTime(LocalDate.now());
        sellerMapper.updateById(seller);
        return 0;
    }


    //TODO AOP修改公共字段，如创建时间，更新时间
    /**
     * 修改商家信息
     * @param sellerUpdateDTO
     */
    @Override
    public void update(SellerUpdateDTO sellerUpdateDTO) {
        Seller seller=new Seller();
        BeanUtils.copyProperties(sellerUpdateDTO,seller);
        seller.setUpdateTime(LocalDate.now());
        sellerMapper.updateById(seller);
    }

    @Override
    public boolean queryByUsername(String username) {
        Seller seller=sellerMapper.queryByUsername(username);
        if (seller==null){
            return false;
        }else {
            return true;
        }
    }


}
