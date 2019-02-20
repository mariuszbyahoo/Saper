public class TileFactory {
    public Tile getInstance(int x, int y){
        Tile tile = new Tile(x,y);
        return tile;
    }
}
