package app.services.register;

import app.dtos.request.RegisterRequest;

public interface RegisterService {

    String register(RegisterRequest registerRequest);
}
