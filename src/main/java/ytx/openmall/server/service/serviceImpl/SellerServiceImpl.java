package ytx.openmall.server.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import ytx.openmall.common.util.JWTUtils;
import ytx.openmall.pojo.DTO.SellerLoginDTO;
import ytx.openmall.pojo.VO.SellerLoginVO;
import ytx.openmall.pojo.entity.Seller;
import ytx.openmall.server.mapper.SellerMapper;
import ytx.openmall.server.service.SellerService;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
@Slf4j
public class SellerServiceImpl implements SellerService {


    @Autowired
    private SellerMapper sellerMapper;


    /**
     * 新增商家
     * @param seller
     */
    @Override
    public void insert(Seller seller) {
        seller.setCreateTime(LocalDate.now());
        seller.setUpdateTime(LocalDate.now());
        //密码加密存储
        byte[] md5Digest = DigestUtils.md5Digest(seller.getPassword().getBytes(StandardCharsets.UTF_8));
        seller.setPassword(Arrays.toString(md5Digest));
        sellerMapper.insert(seller);
    }

    //TODO 登录
    @Override
    public SellerLoginVO login(SellerLoginDTO sellerLoginDTO) {
        String password= Arrays.toString(DigestUtils.md5Digest(sellerLoginDTO.getPassword().getBytes(StandardCharsets.UTF_8)));

        sellerLoginDTO.setPassword(password);
        SellerLoginVO sellerLoginVO=sellerMapper.login(sellerLoginDTO);

        Map<String, Object> map=new HashMap<>();
        map.put("username",sellerLoginVO.getUsername());
        map.put("id",sellerLoginVO.getId());
        String jwt=JWTUtils.generateJWT(map);
        sellerLoginVO.setJwt(jwt);

        return sellerLoginVO;

    }


}
