/*
 * Copyright (C) 2018-2020 University of Waterloo.
 *
 * This file is part of Perses.
 *
 * Perses is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 3, or (at your option) any later version.
 *
 * Perses is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Perses; see the file LICENSE.  If not see <http://www.gnu.org/licenses/>.
 */

package org.perses.fuzzer;

import com.google.common.collect.ImmutableList;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import org.perses.grammar.AbstractParserFacade;
import org.perses.grammar.ParserFacadeFactory;
import org.perses.grammar.c.CParserFacade;
import org.perses.grammar.c.PnfCParserFacade;

import org.perses.program.LanguageKind;
import org.perses.program.TokenizedProgramFactory;

import org.perses.tree.spar.AbstractSparTreeNode;
import org.perses.tree.spar.NodeDeletionActionSet;
import org.perses.tree.spar.NodeDeletionTreeEdit;

import org.perses.tree.spar.SparTree;
import org.perses.tree.spar.SparTreeBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ExecutionException;

public class Fuzzer {

  public static ParseTree generateParseTree(String pathname) throws IOException {
    CParserFacade CParser = new CParserFacade();
    final File testFile = new File(pathname);
    ParseTree treeByOpt = CParser.parseFile(testFile).getTree();
    return treeByOpt;
  }

  // generate spar tree from parseTree

  public static SparTree generateSparTree(ParseTree parseTree) {
    ImmutableList<Token> tokens = AbstractParserFacade.getTokens(parseTree);

    TokenizedProgramFactory tokenizedProgramFactory = TokenizedProgramFactory.createFactory(tokens);

    ParserFacadeFactory factory = ParserFacadeFactory.createForPnfC();

    AbstractParserFacade parserFacade = factory.createParserFacade(LanguageKind.C);

    SparTree sparTree =
        new SparTreeBuilder(parserFacade.getRuleHierarchy(), tokenizedProgramFactory)
            .build(parseTree);
    return sparTree;
  }

  private static List<AbstractSparTreeNode> inorderTreeTraverse(
      AbstractSparTreeNode root, List<AbstractSparTreeNode> currentList) {
    Stack<AbstractSparTreeNode> bufferStack = new Stack<AbstractSparTreeNode>();
    AbstractSparTreeNode currentNode = root;
    if (currentNode == null) {
      System.out.println("!!!");
      return currentList;
    }
    bufferStack.push(currentNode);
    while (!bufferStack.empty()) {
      currentNode = bufferStack.pop();
      currentList.add(currentNode);
      int childCount = currentNode.getChildCount();
      for (int i = 0; i < childCount; ++i) {
        bufferStack.push(currentNode.getChild(i));
      }
    }
    return currentList;
  }

  private static List<AbstractSparTreeNode> flatSparTree(Random rand, SparTree tree) {
    AbstractSparTreeNode root = tree.getRoot();
    List<AbstractSparTreeNode> treeList = new ArrayList<>();
    treeList = inorderTreeTraverse(root, treeList);
    return treeList;
  }

  //
  static void treeMutation(SparTree sparTree, Random rnd) {
    // convert spartree into a list
    List<AbstractSparTreeNode> treeList = flatSparTree(rnd, sparTree);
    // random pop element from treeList
    int index = rnd.nextInt(treeList.size());
    AbstractSparTreeNode nodeToBeDeleted = treeList.get(index);
    treeList.remove(index);

    NodeDeletionActionSet.Builder builder = new NodeDeletionActionSet.Builder("edit 1");
    builder.deleteNode(nodeToBeDeleted);
    NodeDeletionActionSet actionSet = builder.build();
    NodeDeletionTreeEdit treeEdit = sparTree.createNodeDeletionEdit(actionSet);
    //  debugging code, check if applyEdit working properly
    //        System.out.println(nodeToBeDeleted.getNodeId());
    //    System.out.println(sparTree.printTreeStructure());
    sparTree.applyEdit(treeEdit);
    //    System.out.println(sparTree.printTreeStructure());
  }
}
