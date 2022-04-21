package org.prgrms.voucher.dto;

import org.prgrms.voucher.response.ResponseState;
import org.prgrms.voucher.models.VoucherType;

public class VoucherDto {

    public static class CreateVoucherRequest {

        private final VoucherType voucherType;
        private final long discountValue;

        public CreateVoucherRequest(VoucherType voucherType, long discountValue) {

            this.voucherType = voucherType;
            this.discountValue = discountValue;
        }

        public VoucherType getVoucherType() {

            return voucherType;
        }

        public long getDiscountValue() {

            return discountValue;
        }
    }

    public static class CreateVoucherResponse {

        private final Long voucherId;
        private final long voucherValue;
        private final VoucherType voucherType;
        private ResponseState responseState = ResponseState.SUCCESS;

        public CreateVoucherResponse(Long voucherId, long voucherValue, VoucherType voucherType){

            this.voucherId = voucherId;
            this.voucherValue = voucherValue;
            this.voucherType = voucherType;
        }
        public CreateVoucherResponse(Long voucherId, long voucherValue, VoucherType voucherType, ResponseState responseState) {

            this.voucherId = voucherId;
            this.voucherValue = voucherValue;
            this.voucherType = voucherType;
            this.responseState = responseState;
        }

        public Long getVoucherId() {
            return voucherId;
        }

        public ResponseState getResponseState() {
            return responseState;
        }
    }
}
