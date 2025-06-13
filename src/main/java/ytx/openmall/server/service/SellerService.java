package ytx.openmall.server.service;


import ytx.openmall.pojo.DTO.SellerLoginDTO;
import ytx.openmall.pojo.DTO.SellerUpdatePasswordDTO;
import ytx.openmall.pojo.VO.SellerLoginVO;
import ytx.openmall.pojo.entity.Seller;

public interface SellerService {


    void insert(Seller seller);



    SellerLoginVO login(SellerLoginDTO sellerLoginDTO);

    int updatePassword(SellerUpdatePasswordDTO sellerUpdatePasswordDTO);
}
