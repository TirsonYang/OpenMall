package ytx.openmall.server.controller.seller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ytx.openmall.common.constant.RegisterConstant;
import ytx.openmall.common.result.Result;
import ytx.openmall.pojo.DTO.SellerRegisterDTO;
import ytx.openmall.pojo.entity.Seller;
import ytx.openmall.server.service.seller.RegisterService;

import java.util.Map;


@Slf4j
@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/seller/register")
    Result sellerRegister(@RequestBody SellerRegisterDTO sellerRegisterDTO){
        log.info("收到请求");
        if (sellerRegisterDTO.getUsername()==null&&sellerRegisterDTO.getPassword()==null){
            return Result.error(RegisterConstant.NOT_CAN_BE_NULL);
        }
        log.info("username:{},password:{}",sellerRegisterDTO.getUsername(),sellerRegisterDTO.getPassword());
        Seller seller=new Seller();
        BeanUtils.copyProperties(sellerRegisterDTO,seller);
        registerService.insert(seller);

        return Result.success();

    }

}
