package ua.mykola.emergencygrpcapp.service;

import emergency.Emergency;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class DisasterService extends emergency.DisasterServiceGrpc.DisasterServiceImplBase{
    private final NotificationService notificationService;

    @Autowired
    public DisasterService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void reportDisaster(Emergency.DisasterReportRequest request,
                               StreamObserver<Emergency.DisasterReportResponse> responseObserver) {

        notificationService.sendNotification("""
                -------------------
                
                city:%s,
                code:%s,
                description:%s,
                
                -------------------
                """.formatted(request.getCityName(),
                request.getDisasterCode(),
                request.getDescription()));

        Emergency.DisasterReportResponse response = Emergency.DisasterReportResponse.newBuilder()
                .setStatus("The message was got")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
