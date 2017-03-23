package View.ViewBoard;

import ModelBoard.Pieces.Piece;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irindul on 16/02/2017.
 */
public class PieceView {

    private Color color;
    private Color stroke;
    private Piece piece;
    private double tilesize;
    private int offset;

    private List<Rectangle> square;

    public PieceView(Color color, Piece piece, double tilesize, int offset) {
        this(color, piece, tilesize, offset, Color.BLACK);

    }

    public PieceView(Color color, Piece piece, double tilesize, int offset, Color stroke){
        this.color = color;
        this.piece = piece;
        this.tilesize = tilesize;
        this.offset = offset;
        square = new ArrayList<>();

        piece.getPositions().stream()
                .map(position -> {
                    Rectangle rect = new Rectangle(this.tilesize, this.tilesize, this.color);
                    rect.relocate(position.getY()*this.tilesize, position.getX()*this.tilesize);
                    return rect;
                })
                .forEach(rectangle -> square.add(rectangle));
        this.stroke = stroke;
    }



    public synchronized void update(){

        square.clear();
        square = new ArrayList<>();

        piece.getPositions().stream()
                .map(position -> {
                    Rectangle rect = new Rectangle(tilesize, tilesize, color);
                    rect.relocate(position.getY()*tilesize, (position.getX()-offset)*tilesize);
                    rect.setStroke(stroke);
                    return rect;
                })
                .forEach(rectangle -> square.add(rectangle));
    }

    public List<Rectangle> getSquare() {
        return square;
    }

    public Piece getPiece() {
        return piece;
    }

    public Color getColor(){
        return color;
    }

}
