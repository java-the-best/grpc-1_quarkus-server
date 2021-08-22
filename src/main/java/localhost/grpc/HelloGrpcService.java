package localhost.grpc;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;
import proto.GrpcRequest;
import proto.GrpcResponse;
import proto.Service;

@GrpcService
public class HelloGrpcService implements Service {

    @Override
    public Uni<GrpcResponse> grpc(GrpcRequest request) {
        return Uni.createFrom().item(request.getFirstName() + request.getLastName())
                .map(msg -> GrpcResponse.newBuilder().setGreeting(msg).build());
    }
}
