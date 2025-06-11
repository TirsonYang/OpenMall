package ytx.openmall.server.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ytx.openmall.pojo.DTO.SellerRegisterDTO;
import ytx.openmall.pojo.VO.SellerRegisterVO;
import ytx.openmall.server.Mapper.SellerRigsterMapper;
import ytx.openmall.server.service.RegisterService;


@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    private SellerRigsterMapper sellerRigsterMapper;

    @Override
    public SellerRegisterVO register(SellerRegisterDTO sellerRegisterDTO) {
        String username = sellerRegisterDTO.getUsername();
        sellerRigsterMapper.insert(sellerRegisterDTO);
        return null;
    }
}
