package com.example.ttversion1.controller;

import com.example.ttversion1.ResponseObject;
import com.example.ttversion1.entity.ImportDetail;
import com.example.ttversion1.entity.Product;
import com.example.ttversion1.entity.Suppliers;
import com.example.ttversion1.repository.ImportDetailRepo;
import com.example.ttversion1.repository.ProductRepo;
import com.example.ttversion1.repository.SupplierRepo;
import com.example.ttversion1.shareds.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
public class ImportDtController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private SupplierRepo supplierRepo;
    @Autowired
    private ImportDetailRepo importDetailRepo;
    @GetMapping(value = "/admin/importdetail")
    List<ImportDetail> GetAll(){
        return importDetailRepo.findAll();
    }

    @GetMapping(value = "/import/product/{productName}")
    ResponseEntity<ResponseObject> GetImportDtProduct(@PathVariable String productName){
        Optional<Product> product = productRepo.findProductByName(productName);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("FAILDED","Not found the product","")
            );
        } else{
            List<ImportDetail> importDetail = importDetailRepo.getImportDetailByProduct(productName);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK",Constants.OK,importDetail)
            );
        }

    }

    //khong hieu chuc nang
    @PostMapping(value = "/admin/product/import-2/{productname}")
    ResponseEntity<ResponseObject> ImportProduct2(@PathVariable String productname,@RequestParam @Min(1) Integer quantity){
        Optional<Product> product = productRepo.findProductByName(productname.trim());
        List<ImportDetail> importDetails = importDetailRepo.getImportDetailByProduct(productname);
        if (product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("Failed",Constants.NOT_IMPLEMENT,"")
            );
        }else if (importDetails.size()<0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("Failed",Constants.NOT_IMPLEMENT,"")
            );
        }else {
            ImportDetail importDetail = new ImportDetail();
            importDetail.setSupplier(importDetails.get(0).getSupplier());
            importDetail.setProduct(product.get());
            importDetail.setQuantity(quantity);
            importDetail.setPricetotal(importDetails.get(0).getPrice()*quantity);
            importDetail.setCreatedAt(Constants.getCurrentDay());
            importDetail.setUpdatedAt(Constants.getCurrentDay());
            importDetailRepo.save(importDetail);
            product.get().setQuantity(product.get().getQuantity()+quantity);
            productRepo.save(product.get());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","Nhập thêm thành công",product.get())
            );
        }

    }

    @PostMapping("/admin/import/product")
    ResponseEntity<ResponseObject> ImportProduct(
                                                @RequestParam String productName,
                                                @RequestParam Integer supplierId,
                                                @RequestParam Integer price,
                                                @RequestParam Integer quantity
                                                )
    {
        Optional<Product> productId = productRepo.findProductIdByName(productName.trim());
        Optional<Product> product = productRepo.findProductByName(productName.trim());
        Optional<Suppliers> supplier = supplierRepo.findById(supplierId);
        if (quantity<0 || price<0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("FAILED", Constants.NOT_IMPLEMENT, "")
            );
        }
        if(product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("FAILED", Constants.NOT_IMPLEMENT, "")
            );
        }
        if(supplier.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("FAILED", Constants.NOT_IMPLEMENT, "")
            );
        }

        ImportDetail importDetail = new ImportDetail();
        importDetail.setProduct(productId.get());
        importDetail.setSupplier(supplier.get());
        importDetail.setQuantity(quantity);
        importDetail.setPrice(price);
        importDetail.setPricetotal(price*quantity);
        importDetail.setCreatedAt(Constants.getCurrentDay());
        importDetail.setUpdatedAt(Constants.getCurrentDay());
        importDetailRepo.save(importDetail);
        product.get().setQuantity(product.get().getQuantity() + quantity );
        productRepo.save(product.get());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK",Constants.INSERT_SUCCESS,importDetail)
        );
    }





//    @GetMapping(value ="/import/product/{productname}")
//    ResponseEntity<ResponseObject> GetImportDTByProduct(@PathVariable String productname){
//        Optional<Product> product = productRepo.findProductByName(productname.trim());
//        if (product.isPresent()){
//            List<ImportDetail> importDetails = importDetailRepo.findImportByProduct(productname.trim());
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("OK", Constants.OK,importDetails)
//            );
//        }else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                    new ResponseObject("NOT FOUND","Không tồn tại Product trên","")
//            );
//        }
//    }
    @GetMapping(value ="/import/supplier/{SupplierID}")
    ResponseEntity<ResponseObject> GetImportDTBySupplier(@PathVariable int SupplierID){
        Optional<Suppliers> suppliers = supplierRepo.findById(SupplierID);
        if (suppliers.isPresent()){
            List<ImportDetail> importDetails = importDetailRepo.getImportBySupplierID(SupplierID);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", Constants.OK,importDetails)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("NOT FOUND","Không tồn tại Supplier trên","")
            );
        }
    }
//    @PostMapping(value = "/admin/product/import")
//    ResponseEntity<ResponseObject> ImportProduct(@RequestParam String productname,
//                                                 @RequestParam int supplierID,
//                                                 @RequestParam double price,
//                                                 @RequestParam int quantity){
//        Optional<Product> product = productRepo.findProductByName(productname.trim());
//        Optional<Suppliers> suppliers = supplierRepo.findById(supplierID);
//        if (quantity<0 || price<0){
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                    new ResponseObject("FAILED",Constants.NOT_IMPLEMENT,"")
//            );
//        }else  if (product.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                    new ResponseObject("Failed",Constants.NOT_IMPLEMENT,"") // Chuyển hướng vào thêm sản phẩm
//            );
//        }else if (suppliers.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                    new ResponseObject("Failed",Constants.NOT_IMPLEMENT,"")
//            );
//        }else {
//            ImportDetail importDetail = new ImportDetail();
//            importDetail.setProduct(product.get());
//            importDetail.setSupplier(suppliers.get());
//            importDetail.setQuantity(quantity);
//            importDetail.setPrice(price);
//            importDetail.setPricetotal(price*quantity);
//            importDetail.setCreatedAt(Constants.getCurrentDay());
//            importDetail.setUpdatedAt(Constants.getCurrentDay());
//            importDetailRepo.save(importDetail);
//            product.get().setQuantity(product.get().getQuantity()+ quantity);
//            productRepo.save(product.get());
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("OK",Constants.INSERT_SUCCESS,importDetail)
//            );
//        }
//    }

}
