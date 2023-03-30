package com.presentacion.products.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.gson.Gson;
import com.presentacion.products.model.dto.request.MovementsRequest;
import com.presentacion.products.model.dto.response.MovementsResponse;
import com.presentacion.products.model.entity.Movements;
import com.presentacion.products.repository.MovementsRepository;
import com.presentacion.products.util.TestUtil;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class MovementsServiceImplTest {

    @InjectMocks
    private MovementsServiceImpl movementsService;

    @Mock
    private MovementsRepository movementsRepository;


    private static final Gson GSON = new Gson();
    private static final Integer DOCUMENT_NUMBER = Integer.valueOf(77777777);


    @BeforeEach
    void setUp() {
        initMocks(this);
        this.movementsService = new MovementsServiceImpl(movementsRepository);
    }


    @Test
    @DisplayName("Obtiene todos  los datos de los Movimientos")
    public void returnListMovementsResponseWhenGetMovementsIsOk() {
        Movements movements = GSON.fromJson(TestUtil.readJsonFileToString("mock/movements_response.json"),
                Movements.class);
        List<Movements> customerList = new ArrayList<>();
        customerList.add(movements);

        when(movementsRepository.findAll()).thenReturn(customerList);
        TestObserver<MovementsResponse> testObserver = movementsService.findAll().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    @Test
    @DisplayName("Obtiene todos  los datos de los Movimientos acorde al numero de documento")
    public void returnListMovementsResponseWhenfindAllByNumberDocument() {
        Movements movements = GSON.fromJson(TestUtil.readJsonFileToString("mock/movements_response.json"),
                Movements.class);
        List<Movements> customerList = new ArrayList<>();
        customerList.add(movements);

        when(movementsRepository.findAll()).thenReturn(customerList);
        TestObserver<MovementsResponse> testObserver = movementsService.findAllByNumberDocument(DOCUMENT_NUMBER).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    @Test
    @DisplayName("Cuando se guardan correctamente los datos del movimientos")
    public void returnSuccessWhenSaveOk() {
        Movements movements = GSON.fromJson(TestUtil.readJsonFileToString("mock/movements_response.json"),
                Movements.class);
        MovementsRequest movementsRequest = GSON.fromJson(TestUtil.readJsonFileToString("mock/movements_response.json"),
                MovementsRequest.class);
        List<Movements> customerList = new ArrayList<>();
        customerList.add(movements);

        when(movementsRepository.save(any())).thenReturn(movements);
        TestObserver<MovementsResponse> testObserver = movementsService.save(movementsRequest).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    @Test
    @DisplayName("Elimina toda la lista de Movimientos")
    public void returnOkWhenDeleteListMovements(){
        TestObserver<Void> testObserver = movementsService.delete().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }
}