
package com.pm.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log =
            LoggerFactory.getLogger(BillingGrpcService.class);

    // This is the method your generated MethodHandlers actually invokes
    @Override
    public void createBillingAccount(
            BillingRequest billingRequest,
            StreamObserver<BillingResponse> responseObserver) {

        log.info("Create BillingAccount Request: {}", billingRequest);

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
