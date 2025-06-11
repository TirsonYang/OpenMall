package ytx.openmall.server.service.seller.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ytx.openmall.pojo.DTO.SellerRegisterDTO;
import ytx.openmall.pojo.entity.Seller;
import ytx.openmall.server.mapper.seller.SellerRegisterMapper;
import ytx.openmall.server.service.seller.RegisterService;

import java.time.LocalDate;


@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    private SellerRegisterMapper sellerRegisterMapper;


    @Override
    public void insert(Seller seller) {
        seller.setCreateTime(LocalDate.now());
        sellerRegisterMapper.insert(seller);
    }
}
