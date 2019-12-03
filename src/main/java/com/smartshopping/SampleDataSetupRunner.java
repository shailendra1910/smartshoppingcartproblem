package com.smartshopping;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.smartshopping.beans.BillUpdateInfo;
import com.smartshopping.beans.ProductInfo;
import com.smartshopping.beans.ProductInfoForBill;
import com.smartshopping.entity.Bill;
import com.smartshopping.service.BillService;
import com.smartshopping.service.ProductService;
import com.smartshopping.util.BillStatus;
import com.smartshopping.util.ProductCategory;

@Component
public class SampleDataSetupRunner implements CommandLineRunner {

	@Autowired
	private BillService billService;

	final Logger logger = LogManager.getLogger(getClass());

	@Autowired
	private ProductService productService;

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("Inside Runner..");
		setUpProductData();
		setupBillData();
		logger.info("Exiting Runner.. ");
	}

	public void setupBillData() {

		// create a new Bill to update information.
		Bill o1 = billService.createBill(new Bill(0.0, 0, BillStatus.IN_PROGRESS));

		Long billId = o1.getId();
		BillUpdateInfo billUpdateInfo = new BillUpdateInfo();
		List<ProductInfoForBill> productsToBeAdded = new ArrayList<>();
		List<ProductInfoForBill> productsToBeRemoved = new ArrayList<>();

		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-0001", 2));
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-0002", 2));
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-0003", 2));
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-0004", 2));
		productsToBeAdded.add(new ProductInfoForBill("ABC-abc-0005", 2));
		billUpdateInfo.setProductsToBeAdded(productsToBeAdded);
		billUpdateInfo.setProductsToBeRemoved(productsToBeRemoved);
		billUpdateInfo.setStatus(BillStatus.RELEASED);

		logger.info("billUpdateInfo = " + billUpdateInfo);
		billService.updateBill(billUpdateInfo, billId);
		Bill retrieveUpdatedbill = billService.getBillById(o1.getId());
		logger.info("retrieveUpdatedbill = " + retrieveUpdatedbill.getNoOfItems() + "  value ="
				+ retrieveUpdatedbill.getTotalValue());

	}

	private void setUpProductData() {
		productService.createProduct(new ProductInfo("ABC-abc-0001", 20.0, "Apple", ProductCategory.A));
		productService.createProduct(new ProductInfo("ABC-abc-0002", 30.0, "Banana", ProductCategory.B));
		productService.createProduct(new ProductInfo("ABC-abc-0003", 40.0, "Carrot", ProductCategory.C));
		productService.createProduct(new ProductInfo("ABC-abc-0004", 50.0, "Apricot", ProductCategory.A));
		productService.createProduct(new ProductInfo("ABC-abc-0005", 60.0, "Bread", ProductCategory.B));
		productService.createProduct(new ProductInfo("ABC-abc-0006", 70.0, "CashewNut", ProductCategory.C));
		productService.createProduct(new ProductInfo("ABC-abc-0007", 80.0, "Strawberry", ProductCategory.A));
		productService.createProduct(new ProductInfo("ABC-abc-0008", 90.0, "Biscuit", ProductCategory.B));
		productService.createProduct(new ProductInfo("ABC-abc-0009", 100.0, "Curd", ProductCategory.C));
		productService.createProduct(new ProductInfo("ABC-abc-0010", 110.0, "Almond", ProductCategory.A));
	}
}
