package assetManagement;
@FunctionalInterface
public interface FiveFunction<W,V,X,Y,Z,R> {
    R apply(W w,V v,X x,Y y, Z z);
}
