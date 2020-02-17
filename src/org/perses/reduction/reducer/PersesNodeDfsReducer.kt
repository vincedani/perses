/*
 * Copyright (C) 2003-2017 Chengnian Sun.
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
package org.perses.reduction.reducer

import java.util.ArrayDeque
import java.util.Queue
import java.util.function.Function
import org.perses.reduction.ReducerAnnotation
import org.perses.reduction.ReducerContext
import org.perses.reduction.partition.Partition
import org.perses.tree.spar.AbstractSparTreeEdit
import org.perses.tree.spar.AbstractSparTreeNode
import org.perses.tree.spar.SparTree

/** Perses node reducer, with dfs delta debugging  */
open class PersesNodeDfsReducer protected constructor(
  reducerAnnotation: ReducerAnnotation,
  reducerContext: ReducerContext
) : AbstractPersesNodeReducer(reducerAnnotation, reducerContext) {
  private val deltaDebugger = if (reducerContext.configuration.useRealDeltaDebugger)
    DeltaDebugger(
      reducerContext.listenerManager,
      reducerContext.nodeActionSetCache,
      Function { edit: AbstractSparTreeEdit -> testSparTreeEdit(edit) }
    )
  else
    DfsDeltaDebugger(
      reducerContext.listenerManager,
      reducerContext.nodeActionSetCache,
      Function { edit: AbstractSparTreeEdit -> testSparTreeEdit(edit) }
    )

  override fun createReductionQueue(): Queue<AbstractSparTreeNode> {
    return ArrayDeque<AbstractSparTreeNode>(DEFAULT_INITIAL_QUEUE_CAPACITY)
  }

  override fun performDelta(
    tree: SparTree,
    actionsDescription: String,
    vararg startPartitions: Partition
  ) {
    assert(startPartitions.isNotEmpty())
    deltaDebugger.reduce(tree, actionsDescription, *startPartitions)
  }

  companion object {
    const val NAME = "perses_node_with_dfs_delta"
    @JvmField
    val META: ReducerAnnotation = object : ReducerAnnotation() {
      override fun shortName(): String = NAME

      override fun description(): String = ""

      override fun create(reducerContext: ReducerContext) =
        PersesNodeDfsReducer(this, reducerContext)
    }
  }
}