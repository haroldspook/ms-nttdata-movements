package com.presentacion.web.expose;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.gson.Gson;
import com.presentacion.products.model.dto.request.MovementsRequest;
import com.presentacion.products.model.dto.response.MovementsResponse;
import com.presentacion.products.service.MovementsService;
import com.presentacion.products.util.TestUtil;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MovementsControllerTest {

    @InjectMocks
    private MovementsController movementsController;

    @Mock
    private MovementsService movementsService;

    private static final Gson GSON = new Gson();

    @Before
    public void setup(){
        initMocks(this);
    }

  @Test
  @DisplayName("Obtiene todos  los datos de los Movimientos")
  public void returnListMovementsResponseWhenGetMovementsIsOk() {
      MovementsResponse customerResponse = GSON.fromJson(TestUtil.readJsonFileToString("mock/movements_response.json"),
              MovementsResponse.class);
      when(movementsService.findAll()).thenReturn(Observable.just(customerResponse));
      TestObserver<MovementsResponse> testObserver = movementsController.getAllCustomer().test();
      testObserver.awaitTerminalEvent();
      testObserver.assertComplete();
      testObserver.assertNoErrors();
  }

  @Test
  @DisplayName("Elimina toda la lista de Movimientos")
  public void returnOkWhenDeleteListMovements() {
            when(movementsService.delete()).thenReturn(Completable.complete());
            TestObserver<Void> testObserver = movementsController.deleteListCustomer().test();
            testObserver.awaitTerminalEvent();
            testObserver.assertComplete();
            testObserver.assertNoErrors();
  }

    @Test
    @DisplayName("Cuando se guardan correctamente los datos delos movimeintos")
    public void returnSuccessWhenSaveOk() {
            MovementsRequest movementsRequest = GSON.fromJson(TestUtil.readJsonFileToString("mock/movements_request.json"),
                    MovementsRequest.class);
            MovementsResponse movementsResponse = GSON.fromJson(TestUtil.readJsonFileToString("mock/movements_response.json"),
                    MovementsResponse.class);
            when(movementsService.save(any())).thenReturn(Single.just(movementsResponse));
            TestObserver<MovementsResponse> testObserver = movementsController.saveCustomer(movementsRequest).test();
            testObserver.awaitTerminalEvent();
            testObserver.assertComplete();
            testObserver.assertNoErrors();
    }
}