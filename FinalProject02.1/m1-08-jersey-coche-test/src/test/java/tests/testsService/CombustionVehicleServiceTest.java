package tests.testsService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.vehicles.CombustionVehicle;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.Injection;
import com.example.demo.service.CombustionVehicleServiceImpl;

class CombustionVehicleServiceTest {

	CombustionVehicleServiceImpl veh;

	@BeforeEach // se ejecuta antes de cada test
	void setUp() throws Exception {
		veh = new CombustionVehicleServiceImpl();
	}

	@Test
	void testCount() {
		Integer numCombustionVehicles = veh.count();
		assertEquals(2, numCombustionVehicles);
	}

	@Test
	void testFindOne() {
		CombustionVehicle combustionVehicle = veh.findOne(1L);
		assertNotNull(combustionVehicle);
	}

	@Test
	void testFindAll() {
		List<CombustionVehicle> combustionVehicles = veh.findAll();
		assertEquals(2, combustionVehicles.size());

		combustionVehicles = veh.findAll();
		assertEquals(2, combustionVehicles.size());

		for (CombustionVehicle combustionVehicle : combustionVehicles) {
			assertNotNull(combustionVehicle.getId());
		}
	}

	@Test
	void testSave() {
		CombustionVehicle combustionVehicle1 = new CombustionVehicle(1L, "Audi A3", "azul", 4,
				new AirConditioning(true), new Battery("TFSI", 60, 48, true), new Engine("combustión", "L", true),
				new Injection("continua"), true);

		CombustionVehicle result = veh.save(combustionVehicle1);
		assertNotNull(result);
	}

	@Test
	void testFindById() {
		List<CombustionVehicle> combustionVehicles = veh.findById(1L);
		assertEquals(1, combustionVehicles.size());
	}

	@Test
	void testFindByName() {
		List<CombustionVehicle> combustionVehicles = veh.findByName("Audi A3");
		assertEquals(1, combustionVehicles.size());
	}

	@Test
	void testFindByColour() {
		List<CombustionVehicle> combustionVehicles = veh.findByColour("azul");
		assertEquals(1, combustionVehicles.size());
	}

	@Test
	void testFindByNumDoors() {
		List<CombustionVehicle> combustionVehicles = veh.findByNumDoors(4);
		assertEquals(2, combustionVehicles.size());
	}

	@Test
	void testFindByAirConditioningTrue() {
		veh = new CombustionVehicleServiceImpl();
		AirConditioning newAirAc = new AirConditioning(true);
		List<CombustionVehicle> combustionVehicles = veh.findByAirAc(newAirAc);
		assertEquals(2, combustionVehicles.size());
	}

	@Test
	void testFindByAirConditioningFalse() {
		veh = new CombustionVehicleServiceImpl();
		AirConditioning newAirAc = new AirConditioning(false);
		List<CombustionVehicle> combustionVehicles = veh.findByAirAc(newAirAc);
		assertEquals(0, combustionVehicles.size());
	}

	@Test
	void testFindByTypeEngine() {
		veh = new CombustionVehicleServiceImpl();
		List<CombustionVehicle> combustionVehicles = veh.findByTypeEngine();
		assertEquals(2, combustionVehicles.size());
	}

	@Test
	void testFindByOnOffTrue() {
		veh = new CombustionVehicleServiceImpl();
		List<CombustionVehicle> combustionVehicles = veh.findByOnOff(true);
		assertEquals(2, combustionVehicles.size());
	}

	@Test
	void testFindByOnOffFalse() {
		veh = new CombustionVehicleServiceImpl();
		List<CombustionVehicle> combustionVehicles = veh.findByOnOff(false);
		assertEquals(0, combustionVehicles.size());
	}

	@Test
	void testFindByInjection() {
		veh = new CombustionVehicleServiceImpl();
		Injection newInjection = new Injection("continua");
		List<CombustionVehicle> combustionVehicles = veh.findByInjection(newInjection);
		assertEquals(1, combustionVehicles.size());
	}

	@Test
	void testDelete() {
		veh = new CombustionVehicleServiceImpl();

		Long id = 1L;
		boolean results = veh.delete(id);
		assertTrue(results);
	}

	@Test
	void testDeleteAll() {
		veh.deleteAll();
		List<CombustionVehicle> results = veh.findAll();
		assertEquals(0, results.size());
	}
}
