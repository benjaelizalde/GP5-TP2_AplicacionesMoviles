package com.grupo5.app2_capitales.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/grupo5/app2_capitales/data/CiudadDao;", "", "actualizarPoblacion", "", "nombre", "", "nuevaPoblacion", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "borrarPorNombre", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "borrarPorPais", "pais", "insertar", "ciudad", "Lcom/grupo5/app2_capitales/data/Ciudad;", "(Lcom/grupo5/app2_capitales/data/Ciudad;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obtenerPorNombre", "app_debug"})
@androidx.room.Dao()
public abstract interface CiudadDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertar(@org.jetbrains.annotations.NotNull()
    com.grupo5.app2_capitales.data.Ciudad ciudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM ciudades WHERE nombreCiudad = :nombre")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object obtenerPorNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.grupo5.app2_capitales.data.Ciudad> $completion);
    
    @androidx.room.Query(value = "DELETE FROM ciudades WHERE nombreCiudad = :nombre")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object borrarPorNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM ciudades WHERE nombrePais = :pais")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object borrarPorPais(@org.jetbrains.annotations.NotNull()
    java.lang.String pais, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE ciudades SET poblacion = :nuevaPoblacion WHERE nombreCiudad = :nombre")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object actualizarPoblacion(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre, int nuevaPoblacion, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}