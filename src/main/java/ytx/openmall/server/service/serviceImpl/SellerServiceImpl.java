package ytx.openmall.server.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import ytx.openmall.pojo.entity.Seller;
import ytx.openmall.server.mapper.SellerMapper;
import ytx.openmall.server.service.SellerService;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;


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




}
