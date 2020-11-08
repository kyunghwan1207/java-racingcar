package racing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.GrandPrix;
import racing.resolver.SimpleAccelerateResolver;
import racing.service.GrandPrixService;
import racing.service.LineUpService;
import racing.service.RaceMachineService;
import racing.view.to.RacingInputTO;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GrandPrixControllerTest {
    private static final GrandPrixService grandPrixService = new GrandPrixService();
    private static final LineUpService lineUpService = new LineUpService(new RaceMachineService(), new SimpleAccelerateResolver(true));
    private final GrandPrixController grandPrixController = new GrandPrixController(grandPrixService, lineUpService);

    RacingInputTO racingInputTO;

    @BeforeEach
    void makeTestGrandPrix() {
        racingInputTO = new RacingInputTO(Arrays.asList("Lewis", "Botta", "Max"), 5);
    }

    @Test
    void testCreate() {
        GrandPrix grandPrix = grandPrixController.create(racingInputTO);
        assertThat(grandPrix).isNotNull();
        assertThat(grandPrix.getLineUp()).isNotNull();
        assertThat(grandPrix.getLineUp().getMachinesInLap(1)).size().isEqualTo(3);
    }

    @Test
    void testStartRace() {
        GrandPrix grandPrix = grandPrixController.create(racingInputTO);
        grandPrixController.startRace(grandPrix);
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
    }
}

