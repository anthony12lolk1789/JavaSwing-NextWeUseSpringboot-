package Modelo;

import Utilitario.ConexionBD;

import java.sql.*;
import java.util.ArrayList;


public class carrito {
    private int id_carrito;
    private int id_cliente;
    private int id_inventario;
    private int cantidad ;
    private double precio_unitario;
    private double subtotal;

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public int getId_inventario() {
        return id_inventario;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio_unitario() {
        return precio_unitario;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public int getId_carrito() {
        return id_carrito;
    }
    public int getId_cliente() {
        return id_cliente;
    }




    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<carrito> listaProducto = null;
    carrito objProducto = null;



//    public ArrayList<carrito> listarProductos(){
//        try{
//            cn = ConexionBD.getConexionBD();
//            ps = cn.prepareStatement("SELECT * FROM carrito");
//            rs = ps.executeQuery();
//            listaProducto = new ArrayList<>();
//            while(rs.next()){
//                objProducto = new carrito();
//                objProducto.setIdProducto(rs.getInt("idproducto"));
//                objProducto.setId_cliente(rs.getInt("idInventario"));
//                objProducto.setModel(rs.getString("modelo"));
//                objProducto.setColor(rs.getString("color"));
//                objProducto.setCodigo(rs.getString("codigo"));
//                objProducto.setTalla(rs.getInt("talla"));
//
//                listaProducto.add(objProducto);
//            }
//            return listaProducto;
//        }catch(Exception e){
//            System.out.println("Error al listar productos: " + e.getMessage());
//            return null;
//        }
//    }
    public int AgregarProducto(carrito producto){
        int estado = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("INSERT INTO carrito (id_inventario, id_cliente, cantidad, precio_unitario , subtotal ) VALUES (?,?,?,?,?)");
            ps.setInt(1, producto.getId_inventario());
            ps.setInt(2, producto.getId_cliente());
            ps.setInt(3, producto.getCantidad());
            ps.setDouble(4, producto.getPrecio_unitario());
            ps.setDouble(5, producto.getSubtotal());
            estado = ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            return estado;
        }
        return estado;
    }

    public int EliminarProducto(int id_carrito){
        int estado = 0;
        try{
            cn = ConexionBD.getConexionBD();
            ps = cn.prepareStatement("DELETE FROM carrito WHERE id_carrito=?");
            ps.setInt(1, id_carrito);
            estado = ps.executeUpdate();
            cn.close();
            ps.close();
        }catch (Exception e){
            return estado;
        }
        return estado;
    }

}