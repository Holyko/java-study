package demo.structure.tree.binary;

import java.util.Stack;

import demo.Constant.Position;
import demo.structure.tree.node.TreeNode;
import handlers.CompareHandler;
import net.sf.json.JSONObject;

public class BinaryTree<E> {

  private TreeNode<E> root;
  private int size;

  private CompareHandler<E> handler;

  public BinaryTree(CompareHandler<E> compareHandler) {
    root = null;
    size = 0;
    this.handler = compareHandler;
  }

  public TreeNode<E> insert(E e) {
    TreeNode<E> tr = new TreeNode<E>(e);

    TreeNode<E> parent = null;
    TreeNode<E> target = root;

    while (target != null) {
      if (handler.compare(e, target.data()) > 0) {
        parent = target;
        target = target.right();
      } else if (handler.compare(e, target.data()) < 0) {
        parent = target;
        target = target.left();
      } else {
        System.out.println("已存在相同值，target: " + JSONObject.fromObject(target).toString());
        break;
      }
    }

    // 父节点为空，自身为空，那么该节点是root
    if (parent == null && target == null) {
      root = tr;
      size++;
    } else if (parent != null && target == null) {
      if (handler.compare(e, parent.data()) > 0) {
        parent.setRight(tr);
        size++;
        return tr;
      } else if (handler.compare(e, parent.data()) < 0) {
        parent.setLeft(tr);
        size++;
        return tr;
      }
    }
    return null;
  }

  public TreeNode<E> update(E e) {
    return null;
  }

  public TreeNode<E> delete(E e) {
    // 目标节点的父节点
    TreeNode<E> parent = null;

    // 目标节点
    TreeNode<E> delete = root;

    // 目标节点是父节点的左子节点或右子节点
    Position position = null;

    // 定位目标节点
    while (delete != null) {
      if (handler.compare(e, delete.data()) > 0) {
        parent = delete;
        delete = delete.right();
        position = Position.RIGHT;
      } else if (handler.compare(e, delete.data()) < 0) {
        parent = delete;
        delete = delete.left();
        position = Position.LEFT;
      } else {
        System.out.println("找到目标值，target: " + JSONObject.fromObject(delete).toString());
        break;
      }
    }

    // 没有找到目标节点
    if (delete == null) {
      System.out.println("没有找到要删除的节点");
      return null;
    }
    
    // 删除表示
    boolean isDelete = false;

    // 目标节点的左子节点
    TreeNode<E> left = delete.left();
    // 目标节点的右子节点
    TreeNode<E> right = delete.right();

    // 判断目标节点类型：叶节点，单子节点，双子节点
    int type = -1;
    if (left == null && right == null) {
      type = 0;
    } else if (left != null && right == null) {
      type = 1;
    } else if (left == null && right != null) {
      type = 1;
    } else if (left != null && right != null) {
      type = 2;
    } else {
      System.out.println("目标节点类型错误");
      return null;
    }

    // 判断目标节点类别：根节点，普通节点
    int category = -1;
    if (parent == null) {
      category = 0;
    } else {
      category = 1;
    }

    // 当目标节点的类型是叶节点，且类别为根节点
    if (type == 0 && category == 0) {
      delete = null;
      isDelete = true;
    }
    // 当目标节点的类型是叶节点，且类别为普通节点
    if (type == 0 && category == 0) {
      delete = null;
      if (position == Position.LEFT) {
        parent.setLeft(null);
        isDelete = true;
      }
      if (position == Position.RIGHT) {
        parent.setRight(null);
        isDelete = true;
      }
    }
    // 当目标节点的类型是单子节点，且类别为根节点
    if (type == 1 && category == 0) {
      if (left != null) {
        root = delete.left();
        isDelete = true;
      } 
      if(right != null){
        root = delete.right();
        isDelete = true;
      }
    }
    // 当目标节点的类型是单子节点，且类别为普通节点
    if (type == 1 && category == 1) {
      if (position == Position.LEFT && delete.left() != null) {
        parent.setLeft(delete.left());
        isDelete = true;
      }
      if (position == Position.LEFT && delete.right() != null) {
        parent.setLeft(delete.right());
        isDelete = true;
      }
      if (position == Position.RIGHT && delete.left() != null) {
        parent.setRight(delete.left());
        isDelete = true;
      }
      if (position == Position.RIGHT && delete.right() != null) {
        parent.setRight(delete.right());
        isDelete = true;
      }
    }
    // 当目标节点的类型是双子节点，且类别为根节点
    if (type == 2 && category == 0) {
      TreeNode<E> survivorParent = delete;
      TreeNode<E> survivor = right;
      while (survivor.left() != null) {
        survivorParent = survivor;
        survivor = survivor.left();
      }

      if (survivorParent == delete) {
        survivor.setLeft(delete.left());
        root = survivor;
        isDelete = true;
      } else {
        survivorParent.setLeft(survivor.right());
        survivor.setLeft(delete.left());
        survivor.setRight(delete.right());
        root = survivor;
        isDelete = true;
      }
    }
    // 当目标节点的类型是双子节点，且类别为普通节点
    if (type == 2 && category == 1) {
      TreeNode<E> survivorParent = delete;
      TreeNode<E> survivor = right;
      while (survivor.left() != null) {
        survivorParent = survivor;
        survivor = survivor.left();
        isDelete = true;
      }
      
      if (survivorParent == delete && position == Position.LEFT) {
        survivor.setLeft(delete.left());
        parent.setLeft(survivor);
        isDelete = true;
      }
      if (survivorParent == delete && position == Position.RIGHT) {
        survivor.setLeft(delete.left());
        parent.setRight(survivor);
        isDelete = true;
      }
      if (survivorParent != delete && position == Position.LEFT) {
        survivorParent.setLeft(survivor.right());
        survivor.setLeft(delete.left());
        survivor.setRight(delete.right());
        parent.setLeft(survivor);
        isDelete = true;
      }
      if (survivorParent != delete && position == Position.RIGHT) {
        survivorParent.setLeft(survivor.right());
        survivor.setLeft(delete.left());
        survivor.setRight(delete.right());
        parent.setRight(survivor);
        isDelete = true;
      }

    }
    
    if (isDelete) {
      size--;
      return new TreeNode<E>(e);
    }

    return null;
  }

  public TreeNode<E> find(E e) {
    TreeNode<E> target = root;

    while (target != null) {
      if (handler.compare(e, target.data()) > 0) {
        target = target.right();
      } else if (handler.compare(e, target.data()) < 0) {
        target = target.left();
      } else {
        System.out.println("找到目标值，target: " + JSONObject.fromObject(target).toString());
        return target;
      }
    }
    System.out.println("没有找到目标值");
    return null;
  }

  public int size() {
    return size;
  }
  
  public void display() {
    Stack<Object> global = new Stack<>();
    global.push(root);
    int nBlanks = 32;
    boolean isRowEmpty = false;
    System.out.println("。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
    while (!isRowEmpty) {
      Stack<Object> local = new Stack<>();
      isRowEmpty = true;
      for (int i = 0; i < nBlanks; i++) {
        System.out.print(" ");
      }
      
      while (!global.isEmpty()) {
        TreeNode<E> temp = (TreeNode<E>) global.pop();
        if (temp != null) {
          System.out.print(temp.data());
          local.push(temp.left());
          local.push(temp.right());
          if (temp.left() != null || temp.right() != null) {
            isRowEmpty = false;
          }
        } else {
          System.out.print("--");
          local.push(null);
          local.push(null);
        }
        for (int i = 0; i < nBlanks*2 - 2; i++) {
          System.out.print(" ");
        }
      }
      
      System.out.println("");
      nBlanks /= 2;
      while (!local.isEmpty()) {
        global.push(local.pop());
      }
    }

    System.out.println(" END ");
  }

}
