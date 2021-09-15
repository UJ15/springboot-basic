package org.prgms.voucher;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoucherService {

    private final VoucherRepository voucherRepository; // final 생성자 주입을 통해 불변성 확보

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }


    public Voucher getVoucher(UUID voucherId) {
        return voucherRepository
                .findById(voucherId)
                .orElseThrow(() -> new RuntimeException("Can not find a voucher for" + voucherId));
        //voucherRepository 에서 voucherId를 가져오려고 하지만 없는 경우에는 에러를 처리함(cna not find a voucher for id)
    }

    public void deleteVoucher(UUID voucherId) {
        voucherRepository.delete(voucherId);
    }


    public Voucher createVoucher(VoucherType voucherType, long amount) {
        switch (voucherType) {
            case FIXED_AMOUNT:
                var Fixedvoucher = new FixedAmountVoucher(UUID.randomUUID(), amount, voucherType);
                voucherRepository.save(Fixedvoucher);
                return Fixedvoucher;

            case PERCENT_DISCOUNT:
                var Percentvoucher = new PercentDiscountVoucher(UUID.randomUUID(), amount, voucherType);
                voucherRepository.save(Percentvoucher);
                return Percentvoucher;
        }
        return null;
    }

    public List<Voucher> getVouchers() {
        return voucherRepository.findAll();
    }

    public List<Voucher> getVouchersByType(VoucherType voucherType) {
        return voucherRepository.findByVoucherType(voucherType);
    }

    public void useVoucher(Voucher voucher) {
    }
}
