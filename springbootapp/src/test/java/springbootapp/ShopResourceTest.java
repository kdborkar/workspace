package springbootapp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kb.springboot.app.model.Shop;
import com.kb.springboot.app.rest.ShopResource;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ShopResourceTest {
	private MockMvc mvc;
	
	private Shop mockShop1;
	private Shop mockShop2;
	
	
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new ShopResource()).build();
		
		mockShop1 = mock(Shop.class);
		mockShop2 = mock(Shop.class);
		
		when(mockShop1.getShopNumber()).thenReturn("101");
		when(mockShop1.getAddress()).thenReturn("PUNE");
		
		when(mockShop2.getShopNumber()).thenReturn("101");
		when(mockShop2.getAddress()).thenReturn("101");
		when(mockShop2.getLongitude()).thenReturn(73.9876554455d);
		when(mockShop2.getLatitude()).thenReturn(18.6565434d);
		
	}
	
	@Test
	public void testNearestShopList() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/shop/getNearestShop").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
				System.out.println(content());
		
	}
	
	@Test
	public void testAddShop() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/shop/add").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
				System.out.println(content());
		
	}
}
