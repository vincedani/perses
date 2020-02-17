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

import java.util.PriorityQueue
import java.util.Queue
import org.perses.reduction.ReducerAnnotation
import org.perses.reduction.ReducerContext
import org.perses.tree.spar.AbstractSparTreeNode

/** Perses node reducer, with dfs delta debugging  */
class PersesNodePrioritizedDfsReducer(reducerContext: ReducerContext) :
  PersesNodeDfsReducer(META, reducerContext) {
  override fun createReductionQueue(): Queue<AbstractSparTreeNode> {
    return PriorityQueue(
      DEFAULT_INITIAL_QUEUE_CAPACITY, TreeNodeComparatorInLeafTokenCount.SINGLETON)
  }

  companion object {
    const val NAME = "perses_node_priority_with_dfs_delta"
    @JvmField
    val META = object : ReducerAnnotation() {
      override fun shortName() = NAME

      override fun description() = ""

      override fun create(reducerContext: ReducerContext) =
        PersesNodePrioritizedDfsReducer(reducerContext)
    }
  }
}