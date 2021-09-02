package tests.testsService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.HydrogenTank;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.vehicles.HybridVehicle;
import com.example.demo.service.HybridVehicleServiceImpl;

class HybridVehicleServiceTest {

	HybridVehicleServiceImpl veh;

	@BeforeEach // se ejecuta antes de cada test
	void setUp() throws Exception {
		veh = new HybridVehicleServiceImpl();
	}

	@Test
	void testCount() {
		Integer numHybridVehicles = veh.count();
		assertEquals(2, numHybridVehicles);
	}

	@Test
	void testFindOne() {
		HybridVehicle hybridVehicle = veh.findOne(1L);
		assertNotNull(hybridVehicle);
	}

	@Test
	void testFindAll() {
		List<HybridVehicle> hybridVehicles = veh.findAll();
		assertEquals(2, hybridVehicles.size());

		hybridVehicles = veh.findAll();
		assertEquals(2, hybridVehicles.size());

		for (HybridVehicle HybridVehicle : hybridVehicles) {
			assertNotNull(HybridVehicle.getId());
		}
	}

	@Test
	void testSave() {
		HybridVehicle hybridVehicle1 = new HybridVehicle(1L, "Volvo XC60", "gris", 4, new AirConditioning(true),
				new Battery("Full Electric Hybrid", 55, 40, true), new Engine("microhíbrido", "V", true),
				new HydrogenTank("Knauf Automotive"), true);

		HybridVehicle result = veh.save(hybridVehicle1);
		assertNotNull(result);
	}

	@Test
	void testFindById() {
		List<HybridVehicle> hybridVehicles = veh.findById(1L);
		assertEquals(1, hybridVehicles.size());
	}

	@Test
	void testFindByName() {
		List<HybridVehicle> hybridVehicles = veh.findByName("Volvo XC60");
		assertEquals(1, hybridVehicles.size());
	}

	@Test
	void testFindByColour() {
		List<HybridVehicle> hybridVehicles = veh.findByColour("gris");
		assertEquals(1, hybridVehicles.size());
	}

	@Test
	void testFindByNumDoors() {
		List<HybridVehicle> hybridVehicles = veh.findByNumDoors(4);
		assertEquals(2, hybridVehicles.size());
	}

	@Test
	void testFindByAirConditioningTrue() {
		veh = new HybridVehicleServiceImpl();
		AirConditioning newAirAc = new AirConditioning(true);
		List<HybridVehicle> hybridVehicles = veh.findByAirAc(newAirAc);
		assertEquals(2, hybridVehicles.size());
	}

	@Test
	void testFindByAirConditioningFalse() {
		veh = new HybridVehicleServiceImpl();
		AirConditioning newAirAc = new AirConditioning(false);
		List<HybridVehicle> HybridVehicles = veh.findByAirAc(newAirAc);
		assertEquals(0, HybridVehicles.size());
	}

	@Test
	void testFindByTypeEngine() {
		veh = new HybridVehicleServiceImpl();
		List<HybridVehicle> hybridVehicles = veh.findByTypeEngine();
		assertEquals(2, hybridVehicles.size());
	}

	@Test
	void testFindByOnOffTrue() {
		veh = new HybridVehicleServiceImpl();
		List<HybridVehicle> hybridVehicles = veh.findByOnOff(true);
		assertEquals(2, hybridVehicles.size());
	}

	@Test
	void testFindByOnOffFalse() {
		veh = new HybridVehicleServiceImpl();
		List<HybridVehicle> hybridVehicles = veh.findByOnOff(false);
		assertEquals(0, hybridVehicles.size());
	}

	@Test
	void testFindByHydrogenTank() {
		veh = new HybridVehicleServiceImpl();
		HydrogenTank newHydrogenTank = new HydrogenTank("Knauf Automotive");
		List<HybridVehicle> hybridVehicles = veh.findByHydrogenTank(newHydrogenTank);
		assertEquals(2, hybridVehicles.size());
	}

	@Test
	void testDelete() {
		veh = new HybridVehicleServiceImpl();

		Long id = 1L;
		boolean results = veh.delete(id);
		assertTrue(results);
	}

	@Test
	void testDeleteAll() {
		veh.deleteAll();
		List<HybridVehicle> results = veh.findAll();
		assertEquals(0, results.size());
	}

}
