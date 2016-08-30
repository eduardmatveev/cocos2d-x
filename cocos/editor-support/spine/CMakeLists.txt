
set(COCOS_SPINE_SRC

  ${COCOS2D_ROOT}/cocos/editor-support/spine/Animation.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/AnimationState.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/AnimationStateData.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/Atlas.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/AtlasAttachmentLoader.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/Attachment.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/AttachmentLoader.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/Bone.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/BoneData.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/BoundingBoxAttachment.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/Event.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/EventData.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/extension.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/IkConstraint.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/IkConstraintData.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/Json.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/MeshAttachment.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/PolygonBatch.cpp
  ${COCOS2D_ROOT}/cocos/editor-support/spine/RegionAttachment.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/Skeleton.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/SkeletonAnimation.cpp
  ${COCOS2D_ROOT}/cocos/editor-support/spine/SkeletonBounds.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/SkeletonData.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/SkeletonJson.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/SkeletonRenderer.cpp
  ${COCOS2D_ROOT}/cocos/editor-support/spine/Skin.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/SkinnedMeshAttachment.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/Slot.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/SlotData.c
  ${COCOS2D_ROOT}/cocos/editor-support/spine/spine-cocos2dx.cpp
)

include_directories( editor-support )
