package dao.impl;

import com.google.gson.Gson;
import dao.LoginDAO;
import dao.newspapers_api.NewspapersAPI;
import io.reactivex.rxjava3.core.Single;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import modelo.Reader;

public class LoginDAOImpl extends GenericDAO implements LoginDAO {

    private final NewspapersAPI newspapersAPI;

    @Inject
    public LoginDAOImpl(Gson gson, NewspapersAPI newspapersAPI) {
        super(gson);
        this.newspapersAPI = newspapersAPI;
    }

    @Override
    public Single<Either<String, Reader>> getReaderByLogin() {
        return safeAPICall(newspapersAPI.getReaderByLogin());
    }

    @Override
    public Single<Either<String, Boolean>> logout() {
        return safeAPICallResponse(newspapersAPI.logout());
    }

    @Override
    public Single<Either<String, Reader>> registerReader(Reader reader) {
        return safeAPICall(newspapersAPI.registerReader(reader));
    }
}
