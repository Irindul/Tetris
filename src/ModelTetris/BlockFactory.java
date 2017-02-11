package ModelTetris;

import ModelBoard.Direction;
import ModelBoard.Pieces.Block;
import ModelBoard.Pieces.BlockAggregate;
import ModelBoard.Position.Position;

/**
 * Created by Irindul on 10/02/2017.
 */
public class BlockFactory {

    public static Position startingPosition = new Position(0, 4);
    
    public static BlockAggregate get(TetrisBlocks t){
        switch (t){

            case Straight:
                return getStraight();
            case RightL:
                return getRightL();
                
            case LeftL:
                return getLeftL();
                
            case TwoByTwo:
                return getTwoByTwo();
                
            case RightZ:
                return getRightZ();
                
            case LeftZ:
                return getLeftZ();
                
            case ThreeOne:
                return getThreeOne();
                
            default:
                return null;

        }
        
        
    }

    private static BlockAggregate getStraight(){

        Block block = new Block(1 ,4);
        block.setPosition(new Position(startingPosition.getX(), startingPosition.getY()));
        BlockAggregate blockAggregate = new BlockAggregate();
        blockAggregate.add(block);

        return blockAggregate;

    }

    private static BlockAggregate getLeftL(){
        Block block = new Block(3, 1);
        block.setPosition(startingPosition);

        BlockAggregate blockAggregate = new BlockAggregate();
        blockAggregate.add(block);

        Block block1 = new Block(1, 1);
        blockAggregate.add(block1, new Position(2, 0), Direction.LEFT);

        return blockAggregate;
    }

    private static BlockAggregate getRightL(){
        Block block = new Block(3, 1);
        block.setPosition(startingPosition);

        BlockAggregate blockAggregate = new BlockAggregate();
        blockAggregate.add(block);

        Block block1 = new Block(1, 1);
        blockAggregate.add(block1, new Position(2, 0), Direction.RIGHT);

        return blockAggregate;
    }

    private static BlockAggregate getTwoByTwo(){
        Block block = new Block(2, 2);
        block.setPosition(startingPosition);

        BlockAggregate blockAggregate = new BlockAggregate();
        blockAggregate.add(block);

        return blockAggregate;
    }

    private static BlockAggregate getRightZ(){
        Block block = new Block(2 ,1);
        block.setPosition(startingPosition);

        BlockAggregate blockAggregate = new BlockAggregate();
        blockAggregate.add(block);

        Block block1 = new Block(2, 1);
        blockAggregate.add(block1, new Position(1, 0), Direction.RIGHT);

        return blockAggregate;
    }

    private static BlockAggregate getLeftZ(){
        Block block = new Block(2 ,1);
        block.setPosition(startingPosition);

        BlockAggregate blockAggregate = new BlockAggregate();
        blockAggregate.add(block);

        Block block1 = new Block(2, 1);
        blockAggregate.add(block1, new Position(1, 0), Direction.LEFT);

        return blockAggregate;
    }

    private static BlockAggregate getThreeOne(){
        Block block = new Block(1,3);
        block.setPosition(startingPosition);

        BlockAggregate blockAggregate = new BlockAggregate();
        blockAggregate.add(block);

        Block block1 = new Block(1, 1);
        blockAggregate.add(block1, new Position(0, 1), Direction.DOWN);

        return blockAggregate;

    }

}
